package process;

import Model.ExchangeRate;
import Model.Money;

public class Exchanger {
    
    public Money exchange (Money money, ExchangeRate rate){
        
        return new Money(calculate(money, rate),rate.getTo());
    }
    
    private double calculate (Money money, ExchangeRate rate){
            return money.amount*rate.rate;
        }
}
