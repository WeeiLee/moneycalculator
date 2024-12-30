package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.command.Command;
import software.ulpgc.moneycalculator.io.CurrencyDialog;
import software.ulpgc.moneycalculator.model.Currency;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class MainFrame extends JFrame {
    private SwingMoneyDialog moneyDialog;
    private SwingMoneyDisplay display;
    private SwingCurrencyDialog currencyDialog;
    private List<Currency> currencies = new ArrayList<>();
    private Command command;
    public MainFrame() {
        this.setTitle("Money calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(toolbar(), BorderLayout.SOUTH);

    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(createButton());
        return panel;
    }

    private Component createButton() {
        JButton button = new JButton("calculate");
        button.addActionListener(actionEvent -> command.execute());
        return button;
    }

    private Component createContentField() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(createFromDialogPanel());
        panel.add(createToDialogPanel());
        return panel;
    }

    private JTextField createEuroField() {
        JTextField textField =  new JTextField();
        textField.setColumns(5);
        textField.setText("EURO");
        textField.setEditable(false);
        return textField;
    }

    public void join(Command command){
        this.command = command;
    }
    public MainFrame loadCurrencies(List<Currency> currencies){
        this.currencies = currencies;
        this.add(createContentField(), BorderLayout.CENTER);
        return this;
    }

    private JPanel createFromDialogPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.moneyDialog = new SwingMoneyDialog();
        panel.add(moneyDialog);
        panel.add(createEuroField());
        return panel;
    }
    private JPanel createToDialogPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.display = new SwingMoneyDisplay();
        this.currencyDialog = new SwingCurrencyDialog(this.currencies);
        panel.add(display);
        panel.add(currencyDialog);
        return panel;
    }

    public SwingMoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public SwingMoneyDisplay getDisplay() {
        return display;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }
}
