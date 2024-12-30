package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.io.MoneyDisplay;
import software.ulpgc.moneycalculator.model.Money;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private JTextField amountField;


    public SwingMoneyDisplay(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(initAmountField());
    }

    private JTextField initAmountField() {
        amountField = new JTextField();
        amountField.setColumns(6);
        amountField.setEditable(false);
        return amountField;
    }

    @Override
    public void show(Money money) {
        this.amountField.setText(Double.toString(money.amount()));
    }
}
