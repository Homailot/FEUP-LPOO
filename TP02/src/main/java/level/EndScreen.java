package level;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class EndScreen extends Level {
    private int option;
    private List<String> options;

    public EndScreen(int width, int height) {
        super(width, height);
        this.option = 0;
        options = new ArrayList<>();
        options.add("Yes");
        options.add("No");
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFEE"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(width/2-4, height/2),  "You Lost!");
        graphics.putString(new TerminalPosition(width/2-3, height/2 + 2),  "Retry?");

        for(int i = 0; i < options.size(); i++) {
            if(i == option) {
                graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
                graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
            } else {
                graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
                graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFEE"));
            }

            graphics.putString(new TerminalPosition(width/2 + (i)*12 - options.size()*3, height/2 + 4), options.get(i));
        }


    }

    @Override
    protected void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowLeft -> {
                option--;
                if(option < 0) option = 0;
            }
            case ArrowRight -> {
                option++;
                if(option >= options.size()) option = options.size();
            }
            case Enter -> {
                if(option == 0) setState(LevelState.RESTART);
                else setState(LevelState.CLOSING);
            }
        }
    }

    @Override
    public void run(KeyStroke key) {
        processKey(key);
    }
}
