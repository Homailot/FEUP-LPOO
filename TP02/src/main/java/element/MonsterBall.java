package element;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import utils.Position;

import java.util.Random;

public class MonsterBall extends Monster{
    private enum Direction {
        UP_RIGHT,
        UP_LEFT,
        DOWN_RIGHT,
        DOWN_LEFT
    }
    private Direction direction;

    public MonsterBall(int x, int y) {
        super(x, y);
        this.attackPower = 10;
        this.direction = Direction.UP_RIGHT;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#fc0703"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "B");
    }

    @Override
    public Position move() {
        return switch (this.direction) {
            case UP_LEFT -> new Position(super.position.getX() - 1, super.position.getY() - 1);
            case UP_RIGHT -> new Position(super.position.getX() + 1, super.position.getY() - 1);
            case DOWN_LEFT -> new Position(super.position.getX() - 1, super.position.getY() + 1);
            case DOWN_RIGHT -> new Position(super.position.getX() + 1, super.position.getY() + 1);
        };
    }

    @Override
    public void changeDirection() {
        Random random = new Random();

        int pick = random.nextInt(4);

        direction = Direction.values()[pick];
    }
}
