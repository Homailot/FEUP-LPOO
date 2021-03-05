package element;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import utils.Position;

import java.util.Random;

public class Troll extends Monster{
    public Troll(int x, int y) {
        super(x, y);
        super.attackPower = 20;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#fc0703"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "T");
    }

    @Override
    public Position move() {
        Random random = new Random();
        int x,y;

        do {
            x = random.nextInt(3) - 1 + position.getX();
            y = random.nextInt(3) - 1 + position.getY();
        } while(x == position.getX() && y == position.getY());

        return new Position(x, y);
    }
}
