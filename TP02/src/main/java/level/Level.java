package level;

import com.googlecode.lanterna.input.KeyStroke;
import utils.Position;


public abstract class Level {
    protected int width;
    protected int height;

    public LevelState getState() {
        return state;
    }

    public void setState(LevelState state) {
        this.state = state;
    }

    public enum LevelState {
        RUNNING,
        CLOSING
    }
    private LevelState state;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        state = LevelState.RUNNING;
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


    protected boolean canHeroMove(Position position) {
        return position.getX() >= 0 && position.getX() < width && position.getY() >= 0 && position.getY() < height;
    }

    protected abstract void processKey(KeyStroke key);
}
