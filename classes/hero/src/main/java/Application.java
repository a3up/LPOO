import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.terminal.*;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            screen.clear();
            screen.setCharacter(10, 10, new TextCharacter('X'));
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}