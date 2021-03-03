import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;
    private TextGraphics graphics;

    public Game() {
        int width = 40;
        int height = 20;
        try {
            TerminalSize terminalSize = new TerminalSize(width, height);
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

        arena = new Arena(width,height);
        graphics = screen.newTextGraphics();
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            if(!arena.processKey(key)) {
                System.out.println("You LOST!");
                screen.close();
                break;
            }


            KeyType keyType = key.getKeyType();
            if(keyType == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
            } else if (keyType == KeyType.EOF) {
                break;
            }
        }
    }

    public void endGame() throws IOException {
        System.out.println("You died!");
        screen.close();
    }
}
