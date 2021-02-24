import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Hero hero;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            Terminal terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize)
                    .createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }

        hero = new Hero(10, 10);
    }

    private void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> hero.moveUp();
            case ArrowDown -> hero.moveDown();
            case ArrowLeft -> hero.moveLeft();
            case ArrowRight -> hero.moveRight();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);


            KeyType keyType = key.getKeyType();
            if(keyType == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
            } else if (keyType == KeyType.EOF) {
                break;
            }
        }


    }
}
