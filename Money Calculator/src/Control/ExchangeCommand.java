package Control;

import ui.ExchangeDialog;

public class ExchangeCommand {
    
    public ExchangeCommand(){}
    
    public void execute (){ 
        ExchangeDialog exchangeDialog = new ExchangeDialog();
        exchangeDialog.execute();
    }
    
}
