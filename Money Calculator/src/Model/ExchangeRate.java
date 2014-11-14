package Model;

public class ExchangeRate {
    public final Currency from;
    public final Currency to;
    public final double rate;

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public Number getRate() {
        return rate;
    }

    public ExchangeRate(Currency from, Currency to, double rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
    }
   
    
}
