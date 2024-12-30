package software.ulpgc.moneycalculator;
import software.ulpgc.moneycalculator.command.CalculateRateCommand;
import software.ulpgc.moneycalculator.command.Command;
import software.ulpgc.moneycalculator.fixerws.FixerCurrencyLoader;
import software.ulpgc.moneycalculator.fixerws.FixerExchangeRateLoader;
import software.ulpgc.moneycalculator.swing.MainFrame;

public class Main {
    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame().loadCurrencies(
                new FixerCurrencyLoader().load());
        Command command = new CalculateRateCommand(
                mainFrame.getMoneyDialog(),
                mainFrame.getCurrencyDialog(),
                mainFrame.getDisplay(),
                new FixerExchangeRateLoader());
        mainFrame.join(command);
        mainFrame.setVisible(true);
    }
}
