package MoneyCalculator.UI;

import MoneyCalculator.Model.Money;

public class ConsoleMoneyViewer implements MoneyViewer {
    
    public ConsoleMoneyViewer(Money money) {
    }
    
    public ConsoleMoneyViewer(){
    }

    @Override
    public void show(Money money) {
        System.out.println("Cantidad final " + (double) (money.getAmount().getNumerator() / money.getAmount().getDenominator()) + " " + money.getCurrency().getSymbol());
    }
    
    
}
