package Persistance;

import Model.Currency;
import Model.ExchangeRate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ExchangeRateLoaderFromWeb implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency de, Currency a) {
        try {
            URL url = new URL("https://api.exchangeratesapi.io/latest?base=" +
                                de.getCodigo());
            URLConnection connection = url.openConnection();
            return new ExchangeRate(de, a, 
                    getNumberFromConnection(connection, a));
            
        } 
        catch (MalformedURLException ex) {} 
        catch (IOException ex) {}
        return new ExchangeRate(de, a, 0.0);
    }
    
    private double getNumberFromConnection(URLConnection connection, Currency a){
        String line;
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                line = reader.readLine();
                int ini = line.indexOf(a.getCodigo())+5;
                int fin = line.indexOf(",", ini);
                line = line.substring(ini, fin);
        } catch (Exception e){
            return 1.0;
        }
        return Double.parseDouble(line);
    }
}
