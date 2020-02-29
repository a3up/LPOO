import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero = new Hero(10, 10);
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        int i = 0;
        while (i < 5) {
            int x = random.nextInt(width - 2) + 1;
            int y = random.nextInt(height - 2) + 1;
            boolean used = false;
            if (this.hero.getPosition().getX() == x && this.hero.getPosition().getY() == y)
                continue;
            for (Coin c : coins)
                if (c.getPosition().getX() == x && c.getPosition().getY() == y) {
                    used = true;
                    break;
                }
            if (used)
                continue;
            coins.add(new Coin(x, y));
            ++i;
        }
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        int i = 0;
        while (i < 5) {
            int x = random.nextInt(width - 2) + 1;
            int y = random.nextInt(height - 2) + 1;
            boolean used = false;
            if (this.hero.getPosition().getX() == x && this.hero.getPosition().getY() == y)
                continue;
            for (Monster m : monsters)
                if (m.getPosition().getX() == x && m.getPosition().getY() == y) {
                    used = true;
                    break;
                }
            if (used)
                continue;
            for (Coin c : this.coins)
                if (c.getPosition().getX() == x && c.getPosition().getY() == y) {
                    used = true;
                    break;
                }
            if (used)
                continue;
            monsters.add(new Monster(x, y));
            ++i;
        }
        return monsters;
    }

    private boolean canHeroMove(Position position) {
        for (Wall wall : this.walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    private void moveHero(Position position) {
        if (!canHeroMove(position))
            return;
        this.hero.setPosition(position);
        retrieveCoins(position);
    }

    private void retrieveCoins(Position position) {
        for (Coin coin : this.coins) {
            if (coin.getPosition().equals(position)) {
                coins.remove(coin);
                break;
            }
        }
    }

    private void moveMonsters() {
        for (Monster monster : this.monsters) {
            Position aux;
            do
                aux = monster.move();
            while (!canHeroMove(aux));
            monster.setPosition(aux);
        }
    }

    public boolean verifyMonsterCollisions() {
        for (Monster monster : this.monsters)
            if (monster.getPosition().equals(hero.getPosition()))
                return true;
        return false;
    }

    public boolean verifyRemainingCoins() {
        return !this.coins.isEmpty();
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
        moveMonsters();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Coin coin : this.coins)
            coin.draw(graphics);
        for (Monster monster : this.monsters)
            monster.draw(graphics);
        this.hero.draw(graphics);
        for (Wall wall : this.walls)
            wall.draw(graphics);
    }
}
