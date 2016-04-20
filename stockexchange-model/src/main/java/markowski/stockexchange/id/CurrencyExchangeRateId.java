package markowski.stockexchange.id;

import java.io.Serializable;
import java.util.Date;

import markowski.stockexchange.entity.CurrencyEntity;

@SuppressWarnings("serial")
public class CurrencyExchangeRateId  implements Serializable {
	@SuppressWarnings("unused")
	private Date date;
	@SuppressWarnings("unused")
	private CurrencyEntity currencyCode;
}
