import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class Arena {
    int width;
    int height;
    Hero hero = new Hero(10, 10);

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private boolean canHeroMove(Position position) {
        if (position.getX() < 0 || position.getX() >= this.width)
            return false;
        return position.getY() >= 0 && position.getY() < this.height;
    }

    private void moveHero(Position position) {
        if (canHeroMove(position))
            this.hero.setPosition(position);
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp: {
                moveHero(this.hero.moveUp());
                break;
            }
            case ArrowDown: {
                moveHero(this.hero.moveDown());
                break;
            }
            case ArrowLeft: {
                moveHero(this.hero.moveLeft());
                break;
            }
            case ArrowRight: {
                moveHero(this.hero.moveRight());
                break;
            }
        }
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        this.hero.draw(graphics);
    }
}
