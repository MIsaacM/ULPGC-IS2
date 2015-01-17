package Application;

import Control.Command;
import Control.NextImageOperation;
import Control.PrevImageOperation;
import FileSystem.FileImageLoader;
import Model.Image;
import Swing.SwingFrame;
import UI.ImageDisplay;

public class SwingApp {

    public static void main(String[] args) {
        new SwingApp().start(args[0]);
    }

    private void start(String filename) {
        Image image = new FileImageLoader(filename).load();
        SwingFrame frame = new SwingFrame();
        frame.getDisplay().setImage(image);
        frame.register(createOperations(frame.getDisplay()));
        frame.start();       
    }

    private Command[] createOperations(final ImageDisplay display) {
        Command[] commands = new Command[2];
        commands[SwingFrame.NEXT] = new NextImageOperation(display);
        commands[SwingFrame.PREV] = new PrevImageOperation(display);
        return commands;
    }
    
}
