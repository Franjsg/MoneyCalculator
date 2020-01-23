package Model;

public class Currency {

    private final String nombre;
    private final String codigo;
    private final String simbolo;
    
    public Currency(String code, String name, String symbol) {
        this.codigo = code;
        this.nombre = name;
        this.simbolo = symbol;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getSimbolo() {
        return simbolo;
    }
    
    @Override
    public String toString(){
        return codigo + " - " + nombre;
    }
}
