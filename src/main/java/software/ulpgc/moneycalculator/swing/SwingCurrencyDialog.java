package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.io.CurrencyDialog;
import software.ulpgc.moneycalculator.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {
    private JComboBox<String> currenciesList;
    private final List<Currency> currencies;

    public SwingCurrencyDialog(List<Currency> currencies){
        this.currencies = currencies;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        loadCurrency();
        add(currenciesList);
    }

    private void loadCurrency(){
        String[] codes = currencies.stream()
                .map(Currency::code)
                .toArray(String[]::new);
        this.currenciesList = new JComboBox<>(codes);
    }

    @Override
    public Currency get() {
        return new Currency((String)currenciesList.getSelectedItem());
    }
}
