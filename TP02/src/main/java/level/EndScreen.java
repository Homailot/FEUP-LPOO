package level;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class EndScreen extends Level {
    public EndScreen(int width, int height) {
        super(width, height);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(width/2-4, height/2),  "You Lost!");
        graphics.putString(new TerminalPosition(width/2-3, height/2 + 2),  "Retry?");
    }

    @Override
    protected void processKey(KeyStroke key) {

    }

    @Override
    public void run(KeyStroke key) {

    }
}
