package MoneyCalculator.Swing;

import MoneyCalculator.Model.Money;
import MoneyCalculator.Model.Number;
import MoneyCalculator.Control.ExchangeMoneyControl;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import MoneyCalculator.UI.CurrencyDialog;
import MoneyCalculator.UI.MoneyDialog;
import MoneyCalculator.UI.MoneyViewer;

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

    private Number getExchangeRate() throws FileNotFoundException {
        return control.execute().getRate();
    }

    private Number calculateAmount() throws FileNotFoundException {
        return moneyDialog.getMoney().getAmount().multiply(getExchangeRate());
    }

    @Override
    public void excecute() {
        try {
            moneyViewer.show(new Money(currencyDialog.getCurrency(), calculateAmount()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalculateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
