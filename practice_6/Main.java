
public class Main {
    public static void main(String[] args) {
        CharacterFactory factory = new WarriorFactory();
        Character hero = factory.createCharacter("Aidar");
        
        CharacterFactory e_factory = new NecromancerFactory();
        Character enemy = e_factory.createCharacter("Талипов");

        System.out.println("\nначинается бой: " + hero + " VS " + enemy);
        GameEngine.getInstance().startBattle(hero, enemy);
        System.out.println("\nсостояние в конце боя: " + hero + " | " + enemy);
        System.out.println("конец игры.");
    }
}