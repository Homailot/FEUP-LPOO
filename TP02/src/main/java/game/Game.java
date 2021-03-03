package game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import level.Arena;
import level.Level;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;
    private TextGraphics graphics;
    private enum State {
        GAME,
        CLOSING
    }
    private State state;

    public Game() {
        int width = 40;
        int height = 20;
        try {
            TerminalSize terminalSize = new TerminalSize(width, height+5);
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
        state = State.GAME;
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    public void run() throws IOException {
        while (state != State.CLOSING) {
            switch (state) {
                case GAME:
                    draw();
                    KeyStroke key = screen.readInput();

                    processKey(key);
                    arena.run(key);

                    if(arena.getState() == Level.LevelState.CLOSING) {
                        endGame();
                        return;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void processKey(KeyStroke key) throws IOException {
        KeyType keyType = key.getKeyType();
        if(keyType == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
        } else if (keyType == KeyType.EOF) {
            state = State.CLOSING;
        }
    }

    public void endGame() throws IOException {
        System.out.println("You died!");
        screen.close();
        state = State.CLOSING;
    }
}
