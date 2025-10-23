public class Main {
    public static void main(String[] args) {
        try {
            GameEngine game = new GameEngine();
            game.startGame();
        } catch (Exception e) {
            System.err.println("Произошла ошибка во время игры: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
