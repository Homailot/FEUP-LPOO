import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import javax.print.attribute.standard.PDLOverrideSupported;

public class Hero {
    private Position position;

    public Hero() {
        position = new Position(0,0);
    }

    public Hero(int x, int y) {
        position = new Position(x,y);
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

    public void draw(Screen screen) {
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
