package game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import element.Hero;
import element.Monster;
import element.Wall;
import element.Coin;
import utils.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private final Hero hero;
    private final List<Wall> walls;
    private final List<Monster> monsters;
    private final List<Coin> coins;

    public Arena(int width, int height) {
        hero = new Hero(3, 3);
        this.width = width;
        this.height = height;

        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private void retrieveCoins() {
        for(int i = 0; i < this.coins.size(); i++) {
            Coin coin = this.coins.get(i);

            if(this.hero.getPosition().getX() == coin.getPosition().getX() &&
               this.hero.getPosition().getY() == coin.getPosition().getY()) {
                this.coins.remove(i);
                break;
            }
        }
    }

    private void moveHero(Position position) {
        if(canHeroMove(position))
            hero.setPosition(position);

        retrieveCoins();
    }

    private boolean verifyMonsterCollisions() {
        for(Monster monster: monsters) {
            if(monster.getPosition().equals(hero.getPosition())) {
                return true;
            }
        }

        return false;
    }

    private void moveMonsters() {
        Position newPos;

        for(Monster monster: monsters) {
            newPos = monster.move();

            if(canHeroMove(newPos))
                monster.setPosition(newPos);
        }
    }

    public boolean processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> moveHero(hero.moveUp());
            case ArrowDown -> moveHero(hero.moveDown());
            case ArrowLeft -> moveHero(hero.moveLeft());
            case ArrowRight -> moveHero(hero.moveRight());
        }

        if(verifyMonsterCollisions()) return false;

        moveMonsters();

        return !verifyMonsterCollisions();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);

        for(Wall wall: walls)
            wall.draw(graphics);

        for(Coin coin: coins)
            coin.draw(graphics);

        for(Monster monster: monsters)
            monster.draw(graphics);
    }

    private boolean canHeroMove(Position position) {
        for(Wall wall: walls) {
            if(position.equals(wall.getPosition())) return false;
        }

        return position.getX() >= 0 && position.getX() < width && position.getY() >= 0 && position.getY() < height;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for(int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for(int r = 1; r < height -1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width-1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        int x, y;
        boolean overlaps;

        for(int i = 0; i < 5; i++) {
            do {
                overlaps = false;
                x = random.nextInt(width-2) + 1;
                y = random.nextInt(height - 2) + 1;

                if (x == hero.getPosition().getX() && y == hero.getPosition().getY()) {
                    overlaps = true;
                    continue;
                }

                for(Coin coin:coins) {
                    if(x == coin.getPosition().getX() && y == coin.getPosition().getY()) {
                        overlaps = true;
                        break;
                    }
                }
            } while(overlaps);

            coins.add(new Coin(x, y));
        }

        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        int x, y;
        boolean overlaps;

        for(int i = 0; i < 5; i++) {
            do {
                overlaps = false;
                x = random.nextInt(width-2) + 1;
                y = random.nextInt(height - 2) + 1;

                if (x == hero.getPosition().getX() && y == hero.getPosition().getY()) {
                    overlaps = true;
                    continue;
                }

                for(Monster monster:monsters) {
                    if(x == monster.getPosition().getX() && y == monster.getPosition().getY()) {
                        overlaps = true;
                        break;
                    }
                }
            } while(overlaps);

            monsters.add(new Monster(x, y));
        }

        return monsters;
    }
}
