package Model;

public class Money {

    private final double cantidad;
    private final Currency divisa;

    public Money(double amount, Currency currency) {
        this.cantidad = amount;
        this.divisa = currency;
    }

    public double getCantidad() {
        return cantidad;
    }

    public Currency getDivisa() {
        return divisa;
    }
}
