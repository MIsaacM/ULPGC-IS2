package Application;

import Control.ExchangeCommand;
import Persistence.CurrencySetLoader;

public class MoneyCalculator {

    public static void main(String[] args) {
            CurrencySetLoader currencySetLoader = new CurrencySetLoader();
            currencySetLoader.load();
            ExchangeCommand exchangeCommand = new ExchangeCommand();
            exchangeCommand.execute();
    }
    
}
