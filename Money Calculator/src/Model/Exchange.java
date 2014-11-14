package Model;

public class Exchange {
    public final Currency currency;
    public final Money money;

    public Exchange(Currency currency, double amount) {
        this.currency = currency;
        this.money = new Money(amount,currency);
    }
    
    
}
