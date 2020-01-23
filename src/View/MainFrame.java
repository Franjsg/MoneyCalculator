package View;

import Model.Currency;
import Model.CurrencyList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MainFrame extends JFrame {

    private JLabel titulo, cantidad, from, to, res;
    private JTextField tfCantidad, tfRes;
    private JComboBox cbfrom, cbto;
    private JButton bConver;
    
    public MainFrame() {
        this.setTitle("MoneyCalculator");
        this.setSize(620,150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        initComponents();
        situateComponents();
    }
    
    private void initComponents() {
        titulo = new JLabel("Conversor de divisas");
        titulo.setFont(new Font("Arial", 3, 28));
        cantidad = new JLabel("Cantidad: ");
        from = new JLabel(" De: ");
        to = new JLabel(" A: ");
        res = new JLabel("Resultado: ");
        tfCantidad = new JTextField();
        tfCantidad.setColumns(5);
        cbfrom = new JComboBox();
        cbto = new JComboBox();
        tfRes = new JTextField();
        tfRes.setColumns(8);
        tfRes.setEditable(false);
        bConver = new JButton("Calcular");
    }
    
    private void situateComponents() {
        JPanel content = new JPanel(new BorderLayout());
        JPanel panelA = new JPanel();
        panelA.add(new JLabel());
        panelA.add(titulo);
        JPanel panelB = new JPanel();
        panelB.add(cantidad);
        panelB.add(tfCantidad);
        panelB.add(from);
        panelB.add(cbfrom);
        panelB.add(to);
        panelB.add(cbto);
        JPanel panelC = new JPanel();
        panelC.add(bConver);
        panelC.add(new JLabel("           "));
        panelC.add(res);
        panelC.add(tfRes);
        content.add(panelA, BorderLayout.NORTH);
        content.add(panelB, BorderLayout.CENTER);
        content.add(panelC, BorderLayout.SOUTH);
        this.add(content);
    }
    
    public double getCantidad() {
        return Double.parseDouble(tfCantidad.getText());
    }
    
    public Currency getFrom() {
        return (Currency) cbfrom.getSelectedItem();
    }
    
    public Currency getTo() {
        return (Currency) cbto.getSelectedItem();
    }
    
    public void setExchange(double x, String codigo) {
        tfRes.setText(String.format("%.3f", x) + " " + codigo);
    }
    
    public void addRateListener(ActionListener listenforButton) {
        bConver.addActionListener(listenforButton);
    }
    
    public void DisplayErrorMessage(String eMessage) {
        JOptionPane.showMessageDialog(this, eMessage);
    }

    public void addCurrencyList(CurrencyList lista) {
        for (Currency divisa : lista.getCurrencies()) {
            cbfrom.addItem(divisa);
            cbto.addItem(divisa);
        }
    }
}
