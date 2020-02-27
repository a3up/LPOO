import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena = new Arena(40, 12);

    public Game() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.screen.setCursorPosition(null);   // we don't need a cursor
        this.screen.startScreen();             // screens must be started
        this.screen.doResizeIfNecessary();     // resize screen if necessary
    }

    private void processKey(KeyStroke key) {
        this.arena.processKey(key);
    }

    private void draw() throws IOException {
        this.screen.clear();
        this.arena.draw(this.screen.newTextGraphics());
        this.screen.refresh();
    }

    public void run() throws IOException {
        KeyStroke key;
        do {
            draw();
            key = this.screen.readInput();
            processKey(key);
        } while (key.getKeyType() != KeyType.EOF && (key.getKeyType() != KeyType.Character || key.getCharacter() != 'q'));
        this.screen.close();
    }
}
