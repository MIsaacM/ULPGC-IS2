package MoneyCalculator.Persistence;

import MoneyCalculator.Model.Currency;
import MoneyCalculator.Model.ExchangeRate;
import java.util.Date;

public interface ExchangeRateLoader {
    public ExchangeRate load(Date date, Currency from, Currency to);
    public ExchangeRate load(Currency from, Currency to);
}
