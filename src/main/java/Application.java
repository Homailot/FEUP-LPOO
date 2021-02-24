import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            Game newGame = new Game();
            newGame.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
