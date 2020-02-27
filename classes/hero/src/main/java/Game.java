import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Hero hero = new Hero(10, 10);

    public Game() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.screen.setCursorPosition(null);   // we don't need a cursor
        this.screen.startScreen();             // screens must be started
        this.screen.doResizeIfNecessary();     // resize screen if necessary
    }

    private void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp: {
                this.hero.moveUp();
                break;
            }
            case ArrowDown: {
                this.hero.moveDown();
                break;
            }
            case ArrowLeft: {
                this.hero.moveLeft();
                break;
            }
            case ArrowRight: {
                this.hero.moveRight();
                break;
            }
        }
    }

    private void draw() throws IOException {
        this.screen.clear();
        this.hero.draw(screen);
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
