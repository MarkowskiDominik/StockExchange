package markowski.stockexchange.id;

import java.io.Serializable;
import java.util.Date;

import markowski.stockexchange.entity.CurrencyEntity;

public class CurrencyExchangeRateId  implements Serializable {
	private Date date;
	private CurrencyEntity currencyCode;
}
