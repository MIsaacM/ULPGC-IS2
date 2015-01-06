package Swing;

import Model.Money;
import Model.Number;
import Control.ExchangeMoneyControl;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import UI.CurrencyDialog;
import UI.MoneyDialog;
import UI.MoneyViewer;

public class CalculateCommand extends Command {

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer moneyViewer;
    private final ExchangeMoneyControl control;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer moneyViewer, ExchangeMoneyControl control) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
        this.control = control;
    }

    @Override
    public void execute() {
        try {
            moneyViewer.show(new Money(currencyDialog.getCurrency(), calculateAmount()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalculateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Number getExchangeRate() throws FileNotFoundException {
        return control.execute().getRate();
    }

    private Number calculateAmount() throws FileNotFoundException {
        return moneyDialog.getMoney().getAmount().multiply(getExchangeRate());
    }
}
