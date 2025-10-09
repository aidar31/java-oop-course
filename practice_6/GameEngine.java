import java.util.Random;


public class GameEngine {
    private static GameEngine instance;
    private Random rnd = new Random();

    private GameEngine() {}

    public static GameEngine getInstance() {
        if (instance == null) instance = new GameEngine();
        return instance;
    }

    public void startBattle(Character a, Character b) {
        a.game_observer.onEvent("[LOG] бой начинается: " + a.toString() + " VS " + b.toString());
    }
}