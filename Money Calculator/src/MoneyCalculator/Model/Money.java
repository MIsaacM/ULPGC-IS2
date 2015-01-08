package MoneyCalculator.Model;

public class Money {

    public final Number amount;
    public final Currency currency;

    public Money(Currency currency, Number amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Number getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount.getNumerator()/amount.getDenominator() + " " + currency.getCode();
    }   
}