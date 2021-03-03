package element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import utils.Position;

public class Hero extends Element {
    private int health;
    private int maxHealth;
    private int score;

    public Hero(int x, int y) {
        super(x,y);
        health = 100;
        maxHealth = 100;
        score = 0;
    }


    public Position moveUp() {
        return new Position(position.getX(), position.getY()-1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY()+1);
    }

    public Position moveLeft() {
        return new Position(position.getX()-1, position.getY());

    }

    public Position moveRight() {
        return new Position(position.getX()+1, position.getY());
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0) this.health = 0;
        else this.health = Math.min(health, maxHealth);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
