package MoneyCalculator.Control;

import MoneyCalculator.Model.Currency;
import MoneyCalculator.Model.ExchangeRate;
import MoneyCalculator.Model.Money;
import MoneyCalculator.Persistence.ExchangeRateLoader;
import java.io.FileNotFoundException;
import MoneyCalculator.UI.CurrencyDialog;
import MoneyCalculator.UI.MoneyDialog;
import MoneyCalculator.UI.MoneyViewer;

public class ExchangeMoneyControl {

    ExchangeRateLoader exchangeRateLoader;
    MoneyDialog moneyDialog;
    CurrencyDialog currencyDialog;
    MoneyViewer moneyViewer;

    public ExchangeMoneyControl(ExchangeRateLoader exchangeRateLoader, MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer moneyViewer) {
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
    }


    public ExchangeRate execute() throws FileNotFoundException {
        Money money = readMoney();
        Currency currency = readCurrency();
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.getCurrency(), currency);
        return exchangeRate;
    //    moneyViewer.show(MoneyExchanger.exchange(money, exchangeRate));
    }

    private Money readMoney() {
        return moneyDialog.getMoney();
    }

    private Currency readCurrency() {
        return currencyDialog.getCurrency();
    }
    
}
