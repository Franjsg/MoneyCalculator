package Control;

import Model.Currency;
import Model.CurrencyList;
import Persistance.ExchangeRateLoaderFromWeb;
import View.MainFrame;
import java.awt.event.*;

public class Controller {
    private MainFrame frame;
    private CurrencyList lista;
    private ExchangeRateLoaderFromWeb exchange;

    public Controller(MainFrame View, CurrencyList lista,
                                        ExchangeRateLoaderFromWeb exchangeRate) {
        this.frame = View;
        this.lista = lista;
        this.exchange = exchangeRate;
        frame.addRateListener(new RateListener());
        frame.addCurrencyList(lista);
        frame.setVisible(true);
    }

    private class RateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            double cantidad;
            Currency from;
            Currency to;
            double rate;
            
            try {
              cantidad = frame.getCantidad();
              from = frame.getFrom();
              to = frame.getTo();
              rate = exchange.load(from, to).getRate();
              frame.setExchange(cantidad * rate, to.getSimbolo());
            } catch (NumberFormatException ex) {
                frame.DisplayErrorMessage("Introduce un número");
            }
        }
    }
   
}
