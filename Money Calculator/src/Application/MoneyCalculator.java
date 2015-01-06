package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import Control.ExchangeMoneyControl;
import Model.Currency;
import Persistence.ExchangeRateLoader;
import Persistence.FileCurrencySetLoader;
import Persistence.FileExchangeRateLoader;
import Swing.ActionListenerFactory;
import Swing.ApplicationFrame;
import Swing.CalculateCommand;
import Swing.Command;
import UI.CurrencyDialog;
import UI.MoneyDialog;
import UI.MoneyViewer;


public class MoneyCalculator {

    public static void main(String[] args) throws FileNotFoundException {

        new Application().execute();

    }

    private HashMap<String, Command> commandMap;

    private void execute() throws FileNotFoundException {
        String fileCurrencies = "/Users/Adriel/Desktop/Universidad/Proyectos_Netbeans/MoneyCalculator/src/moneycalculator/currencies";
        String fileRates = "/Users/Adriel/Desktop/Universidad/Proyectos_Netbeans/MoneyCalculator/src/moneycalculator/rate";
        FileCurrencySetLoader.getInstance().load(readCurrencies(fileCurrencies));
        ApplicationFrame frame = createApplicationFrame();
        ExchangeMoneyControl control = createFileExchangeMoneyControl(fileRates, frame);
        createCommands(frame, control);
    }

    private ExchangeMoneyControl createFileExchangeMoneyControl(String fileRates, ApplicationFrame frame) {
        return new ExchangeMoneyControl(createExchangeRateLoader(fileRates), createMoneyDialog(frame), createCurrencyDialog(frame), createMoneyViewer(frame));
    }

    private ExchangeRateLoader createExchangeRateLoader(String fileRates) {
        return new FileExchangeRateLoader(fileRates);
    }

    private Currency[] readCurrencies(String fileCurrencies) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileCurrencies)));
        ArrayList<String> listString = new ArrayList<>();
        while (true) {
            String line;
            try {
                line = reader.readLine();
                if (line == null)
                    break;
                listString.add(line);
            } catch (IOException e) {
                break;
            }
        }
        return fromString(listString);
    }

    private Currency[] fromString(ArrayList<String> listString) {
        ArrayList<Currency> listCurrency = new ArrayList<>();
        for (String string : listString)
            listCurrency.add(new Currency(string.split("-")[0], string.split("-")[1], string.split("-")[2]));
        return listCurrency.toArray(new Currency[0]);
    }

    private MoneyDialog createMoneyDialog(ApplicationFrame frame) {
        return frame.getMoneyDialog();
    }

    private CurrencyDialog createCurrencyDialog(ApplicationFrame frame) {
        return frame.getCurrencyDialog();
    }

    private MoneyViewer createMoneyViewer(ApplicationFrame frame) {
        return frame.getMoneyViewer();
    }

    private void createCommands(ApplicationFrame frame, ExchangeMoneyControl control) {
        commandMap = new HashMap<>();
        commandMap.put("calculate", new CalculateCommand(
                frame.getMoneyDialog(),
                frame.getCurrencyDialog(),
                frame.getMoneyViewer(),
                control
        ));
        commandMap.put("exit", new Command() {

            @Override
            public void execute() {
                System.exit(0);
            }
        });
    }

    private ApplicationFrame createApplicationFrame() {
        return new ApplicationFrame(new ActionListenerFactory() {

            @Override
            public ActionListener createActionListener(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Command command = commandMap.get(action);
                        if (command == null)
                            return;
                        command.execute();
                    }
                };
            }
        });

    }
    
}
