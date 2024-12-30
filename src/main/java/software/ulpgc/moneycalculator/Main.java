package software.ulpgc.moneycalculator;
import software.ulpgc.moneycalculator.command.CalculateRateCommand;
import software.ulpgc.moneycalculator.command.Command;
import software.ulpgc.moneycalculator.swing.MainFrame;

public class Main {
    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();
        Command command = new CalculateRateCommand(
                mainFrame.getMoneyDialog(),
                mainFrame.getCurrencyDialog(),
                mainFrame.getDisplay()
        );
        mainFrame.join(command);
        mainFrame.setVisible(true);
    }
}
