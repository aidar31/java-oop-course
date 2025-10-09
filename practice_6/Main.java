import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Мини-RPG!");
        System.out.println("выбери класс героя: 1-воин, 2-маг, 3-лучник, 5-некромант");
        System.out.print("твoй выбор: ");
        String choice = sc.nextLine();

        System.out.print("введи имя героя: ");
        String name = sc.nextLine();

        CharacterFactory factory;
        switch (choice) {
            case "1": factory = new WarriorFactory(); break;
            case "2": factory = new MageFactory(); break;
            case "3": factory = new ArcherFactory(); break;
            case "4": factory = new NecromancerFactory(); break;
            default:
                System.out.println("воин по умолчанию.");
                factory = new WarriorFactory();
        }

        Character hero = factory.createCharacter(name);

        AttackStrategy enemyStrategy = new BowAttack(14, 2);
        Enemy enemy;
        if (Math.random() < 0.4) {
            enemy = new Minion("Гнустный Талипов", 60, enemyStrategy);
        } else {
            enemy = new BossEnemy("Злобный Талипов", 95, new MagicAttack(16, 3));
        }

        System.out.println("\nначинается бой: " + hero + " VS " + enemy);
        GameEngine.getInstance().startBattle(hero, enemy);

        System.out.println("\nсостояние в конце боя: " + hero + " | " + enemy);
        System.out.println("конец игры.");
    }
}