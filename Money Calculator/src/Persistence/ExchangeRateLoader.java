package Persistence;

import Model.Currency;
import Model.ExchangeRate;
import java.util.Date;

public class ExchangeRateLoader {
    public interface ExchangeRateLoader {
        public ExchangeRate load(Date date, Currency from, Currency to);
        public ExchangeRate load(Currency from, Currency to);
    }
}
