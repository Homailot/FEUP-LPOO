import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;

    public Arena(int width, int height) {
        hero = new Hero(10, 10);
        this.width = width;
        this.height = height;

        this.walls = createWalls();
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

    public void moveHero(Position position) {
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> moveHero(hero.moveUp());
            case ArrowDown -> moveHero(hero.moveDown());
            case ArrowLeft -> moveHero(hero.moveLeft());
            case ArrowRight -> moveHero(hero.moveRight());
        }
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);

        for(Wall wall: walls)
            wall.draw(graphics);
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
}
