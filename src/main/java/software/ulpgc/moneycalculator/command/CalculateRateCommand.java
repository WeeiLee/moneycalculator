package software.ulpgc.moneycalculator.command;

import software.ulpgc.moneycalculator.fixerws.FixerExchangeRateLoader;
import software.ulpgc.moneycalculator.model.ExchangeRate;
import software.ulpgc.moneycalculator.model.Money;
import software.ulpgc.moneycalculator.io.CurrencyDialog;
import software.ulpgc.moneycalculator.swing.SwingMoneyDialog;
import software.ulpgc.moneycalculator.swing.SwingMoneyDisplay;

public class CalculateRateCommand implements Command{

    private final SwingMoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final SwingMoneyDisplay display;

    public CalculateRateCommand(SwingMoneyDialog moneyDialog, CurrencyDialog currencyDialog, SwingMoneyDisplay display) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.display = display;
    }

    @Override
    public void execute() {
        this.display.show(exchange());
    }

    private Money exchange() {
        ExchangeRate rate = new FixerExchangeRateLoader().load(currencyDialog.get());
        double amount = rate.rate() * moneyDialog.get().amount();
        return new Money(amount, currencyDialog.get());
    }
}
