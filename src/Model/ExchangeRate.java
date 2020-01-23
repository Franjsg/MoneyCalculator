package Model;

public class ExchangeRate {

    private final Currency de;
    private final Currency a;
    private final double rate;

    public ExchangeRate(Currency from, Currency to, double rate) {
        this.de = from;
        this.a = to;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public Currency getDe() {
        return de;
    }

    public Currency getA() {
        return a;
    }  
}
