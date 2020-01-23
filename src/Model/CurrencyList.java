package Model;

import java.util.ArrayList;
import java.util.List;


public final class CurrencyList {

    private final ArrayList<Currency> lista;
    
    public CurrencyList() {
        lista = new ArrayList<>();
    }
    
    public List<Currency> getCurrencies() {
        return lista;
    }
    
    public void add(Currency currency) {
        lista.add(currency);
    }    
}
