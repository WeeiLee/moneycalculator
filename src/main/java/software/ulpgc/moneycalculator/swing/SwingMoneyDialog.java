package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.io.MoneyDialog;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.Money;

import javax.swing.*;
import java.awt.*;



public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private JTextField amountField;


    public SwingMoneyDialog(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(initAmountField());
    }

    private JTextField initAmountField() {
        amountField = new JTextField();
        amountField.setColumns(8);
        return amountField;
    }

    @Override
    public Money get() {
        return new Money(Long.parseLong(amountField.getText()), new Currency("EUR"));
    }

}
