package Model;

import java.util.Date;

public class ExchangeRate {
    
    public final Date date;
    public final Currency from, to;
    public final Number rate;

    public ExchangeRate(Date date, Currency from, Currency to, Number rate) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }
    
    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public Number getRate() {
        return rate;
    }
}