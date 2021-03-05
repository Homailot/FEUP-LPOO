package element;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import utils.Position;


public abstract class Monster extends Element {
    protected int attackPower;

    public Monster(int x, int y) {
        super(x, y);
        attackPower = 12;
    }


    public abstract Position move();

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#fc0703"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }

    public void changeDirection() {

    }

    public int getAttackPower() {
        return attackPower;
    }
}
