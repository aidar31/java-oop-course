import java.util.Scanner;

// конкретная реализация боевой системы с интерактивным управлением
public class InteractiveBattleSystem extends BattleSystem {
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    protected void heroTurn(Hero hero, Monster monster) {
        System.out.println("\n--- Ход героя ---");
        System.out.println("Выберите действие:");
        System.out.println("1. Атаковать");
        System.out.println("2. Использовать предмет");
        System.out.println("3. Убежать");
        
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    hero.attack(monster);
                    break;
                case 2:
                    useItem(hero);
                    break;
                case 3:
                    System.out.println(hero.getName() + " убегаешь из боя!=D");
                    hero.takeDamage(hero.getHealth()); // "Убиваем" героя для выхода из боя
                    break;
                default:
                    System.out.println("Неверный выбор! Вы пропускает ход.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод! Вы пропускает ход.");
        }
    }
    
    private void useItem(Hero hero) {
        if (hero.getInventory().isEmpty()) {
            System.out.println("У тя нет предметов!");
            return;
        }
        
        System.out.println("Выбери предмет для использования:");
        for (int i = 0; i < hero.getInventory().size(); i++) {
            System.out.println((i + 1) + ". " + hero.getInventory().get(i));
        }
        
        try {
            int itemIndex = Integer.parseInt(scanner.nextLine()) - 1;
            if (itemIndex >= 0 && itemIndex < hero.getInventory().size()) {
                hero.useItem(itemIndex);
            } else {
                System.out.println("Неверный номер предмета!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод!");
        }
    }
    
    @Override
    protected void monsterTurn(Hero hero, Monster monster) {
        System.out.println("\n--- Ход монстра ---");
        
        // Случайный выбор между обычной атакой и специальной способностью
        if (Math.random() < 0.3) { // 30% шанс на специальную способность
            monster.specialAbility(hero);
        } else {
            monster.attack(hero);
        }
    }
}
