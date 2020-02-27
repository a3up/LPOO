import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

public class Arena {
    int width;
    int height;
    Hero hero = new Hero(10, 10);

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private boolean canHeroMove(Position position) {
        if(position.getX() < 0 || position.getX() > this.width)
            return false;
        if(position.getY() < 0 || position.getY() > this.height)
            return false;
        return true;
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

    public void draw(Screen screen) {
        this.hero.draw(screen);
    }
}
