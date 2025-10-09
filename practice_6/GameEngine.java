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

        Character first = rnd.nextBoolean() ? a : b;
        Character second = first == a ? b : a;
        a.game_observer.onEvent("[LOG] ходит первым: " + first.getName());

        // пока кто то не помрет
        while (a.isAlive() && b.isAlive()) {
            first.performAttack(second);
            if (!second.isAlive()) break;

            second.performAttack(first);
            if (!first.isAlive()) break;

            a.game_observer.onEvent("[LOG] --- следующий раунд ---");
        }

        String winner = a.isAlive() ? a.getName() : b.getName();
        a.game_observer.onEvent("[LOG] 🏆 Победитель: " + winner);
    }
}
