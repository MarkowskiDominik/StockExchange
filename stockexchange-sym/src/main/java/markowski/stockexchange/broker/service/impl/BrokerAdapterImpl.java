package markowski.stockexchange.broker.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.bank.service.BankAdapter;
import markowski.stockexchange.broker.service.BrokerAdapter;
import markowski.stockexchange.broker.service.StockQuotesService;
import markowski.stockexchange.broker.service.StocksPurchasedByClientService;
import markowski.stockexchange.broker.service.TransactionService;
import markowski.stockexchange.date.DateProvider;
import markowski.stockexchange.enums.TransactionStatus;
import markowski.stockexchange.enums.TransactionType;
import markowski.stockexchange.to.PaymentConfirmationTo;
import markowski.stockexchange.to.StockQuotesTo;
import markowski.stockexchange.to.StocksPurchasedByClientTo;
import markowski.stockexchange.to.TransactionTo;

@Service("BrokerAdapter")
@Transactional
public class BrokerAdapterImpl implements BrokerAdapter {

	private static final BigDecimal PROVISION = new BigDecimal(0.5);
	private static final int MINIMAL_PROVISION = 5;
	private static final String CURRENCY_CODE = "PLN";

	@Autowired
	private StockQuotesService stockQuotesService;
	@Autowired
	private StocksPurchasedByClientService stocksPurchasedByClientService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private BankAdapter bankAdapter;

	@Override
	public List<StocksPurchasedByClientTo> getClientStocks(Long brokerAccount) {
		return stocksPurchasedByClientService.getStockPurchsedByClient(brokerAccount);
	}

	@Override
	public List<StockQuotesTo> getActualyStockQuotes() {
		return stockQuotesService.getStockQuotesByDataRange(DateProvider.getCurrentDate(),
				DateProvider.getCurrentDate());
	}

	@Override
	public List<TransactionTo> preprocessClientOffer(List<TransactionTo> generatedClientOffer) {
		List<TransactionTo> transactions = new ArrayList<TransactionTo>();
		for (TransactionTo clientOffer : generatedClientOffer) {
			transactions.add(transactionService.save(preprocessOffer(clientOffer)));
		}
		return transactions;
	}

	public TransactionTo preprocessOffer(TransactionTo offer) {
		Integer numberOfStocks = calculateNumberOfStocks(offer.getNumberOfStocks());
		BigDecimal totalPrice = calculatePrice(offer.getType(), numberOfStocks,
				stockQuotesService.getActualyStockQuotesByCompanyName(offer.getCompanyName()));

		return new TransactionTo(null, offer.getBrokerAccount(), offer.getCompanyName(), numberOfStocks, totalPrice,
				offer.getType(), offer.getStatus());
	}

	private Integer calculateNumberOfStocks(Integer numberOfStocks) {
		float randomPercent = new Random().nextFloat() * 0.2f + 0.8f;
		return Math.round(numberOfStocks * randomPercent);
	}

	private BigDecimal calculatePrice(TransactionType type, int numberOfStocks,
			StockQuotesTo actualyStockQuotesByCompanyName) {
		BigDecimal ratioOfOrginalPrice;
		if (TransactionType.SELL.equals(type)) {
			ratioOfOrginalPrice = new BigDecimal(new Random().nextDouble() * 0.02 + 0.98);
		} else {
			ratioOfOrginalPrice = new BigDecimal(new Random().nextDouble() * 0.02 + 1.0);
		}
		BigDecimal unitPriceForThisClient = actualyStockQuotesByCompanyName.getUnitPrice()
				.multiply(ratioOfOrginalPrice);
		BigDecimal priceWithoutProvision = new BigDecimal(numberOfStocks).multiply(unitPriceForThisClient);
		BigDecimal totalPrice;
		if (priceWithoutProvision.multiply(PROVISION).intValue() > MINIMAL_PROVISION) {
			totalPrice = priceWithoutProvision.multiply(PROVISION);
		} else {
			totalPrice = priceWithoutProvision.add(new BigDecimal(MINIMAL_PROVISION));
		}
		return totalPrice;
	}

	@Override
	public Long getBankAccount() {
		return 1000L;
	}

	@Override
	public void buyStocks(TransactionTo clientTransaction, PaymentConfirmationTo paymentConfirmationTo) {
		TransactionTo transactionInBase = transactionService.getTransaction(clientTransaction.getIdTransaction());

		StocksPurchasedByClientTo stockPurchasedByClientTo = stocksPurchasedByClientService
				.getStockPurchsedByClientAndCompany(clientTransaction.getBrokerAccount(),
						clientTransaction.getCompanyName());
		if (stockPurchasedByClientTo != null) {
			addNumberOfStockPurchased(stockPurchasedByClientTo, transactionInBase);
		} else {
			stockPurchasedByClientTo = new StocksPurchasedByClientTo(null, clientTransaction.getBrokerAccount(),
					clientTransaction.getCompanyName(), clientTransaction.getNumberOfStocks(),
					clientTransaction.getTotalPrice().divide(new BigDecimal(clientTransaction.getNumberOfStocks())));
		}

		stocksPurchasedByClientService.save(stockPurchasedByClientTo);
		transactionInBase.setStatus(TransactionStatus.ACCEPT);
		transactionService.save(transactionInBase);
	}

	private void addNumberOfStockPurchased(StocksPurchasedByClientTo stockPurchasedByClientTo,
			TransactionTo transactionInBase) {
		Integer numberOfStockTransaction = transactionInBase.getNumberOfStocks();
		BigDecimal totalPriceTransaction = transactionInBase.getTotalPrice();
		Integer numberOfStockPurchased = stockPurchasedByClientTo.getNumberOfStocks();
		BigDecimal averagePriceStockPurchased = stockPurchasedByClientTo.getAveragePurchasePrice()
				.multiply(new BigDecimal(numberOfStockPurchased));
		BigDecimal totalPriceStockPurchased = averagePriceStockPurchased
				.multiply(new BigDecimal(numberOfStockPurchased));
		Integer totalNumberOfStock = numberOfStockTransaction + numberOfStockPurchased;

		stockPurchasedByClientTo.setNumberOfStocks(numberOfStockPurchased + numberOfStockTransaction);
		stockPurchasedByClientTo.setAveragePurchasePrice((totalPriceStockPurchased.add(totalPriceTransaction)
				.divide(new BigDecimal(totalNumberOfStock), 2, RoundingMode.HALF_UP)));

	}

	@Override
	public PaymentConfirmationTo sellStocks(TransactionTo clientTransaction, Long bankAccount) {
		PaymentConfirmationTo paymentConfirmationTo = bankAdapter.makeBankTransfer(getBankAccount(), bankAccount,
				clientTransaction.getIdTransaction(), clientTransaction.getTotalPrice(), CURRENCY_CODE);

		TransactionTo transactionInBase = transactionService.getTransaction(clientTransaction.getIdTransaction());

		StocksPurchasedByClientTo stockPurchasedByClientTo = stocksPurchasedByClientService
				.getStockPurchsedByClientAndCompany(clientTransaction.getBrokerAccount(),
						clientTransaction.getCompanyName());
		if (stockPurchasedByClientTo != null) {
			subtractNumberOfStockPurchased(stockPurchasedByClientTo, transactionInBase);
		} else {
			stockPurchasedByClientTo = new StocksPurchasedByClientTo(null, clientTransaction.getBrokerAccount(),
					clientTransaction.getCompanyName(), clientTransaction.getNumberOfStocks(),
					clientTransaction.getTotalPrice().divide(new BigDecimal(clientTransaction.getNumberOfStocks())));
		}
		
		stocksPurchasedByClientService.save(stockPurchasedByClientTo);
		transactionInBase.setStatus(TransactionStatus.ACCEPT);
		transactionService.save(transactionInBase);

		return paymentConfirmationTo;
	}

	private void subtractNumberOfStockPurchased(StocksPurchasedByClientTo stockPurchasedByClientTo,
			TransactionTo transactionInBase) {
		Integer numberOfStockTransaction = transactionInBase.getNumberOfStocks();
		Integer numberOfStockPurchased = stockPurchasedByClientTo.getNumberOfStocks();

		stockPurchasedByClientTo.setNumberOfStocks(numberOfStockPurchased - numberOfStockTransaction);
	}

}
