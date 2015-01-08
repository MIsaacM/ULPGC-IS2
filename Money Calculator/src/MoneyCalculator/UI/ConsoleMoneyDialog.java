package MoneyCalculator.UI;

import MoneyCalculator.Model.Money;
import MoneyCalculator.Model.Number;
import com.sun.istack.internal.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class ConsoleMoneyDialog implements MoneyDialog {
    
    private Money money;

    @Override
    public Money getMoney() {
        return money;
    }

    @Override
    public void execute() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduzca la cantidad");
            Number number = new Number(Double.valueOf(readAmount(reader)));
            ConsoleCurrencyDialog currency = new ConsoleCurrencyDialog();
            currency.execute();
            this.money = new Money(currency.getCurrency(), number);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ConsoleMoneyDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String readAmount(BufferedReader reader) throws IOException {
        return reader.readLine();
    }
}
