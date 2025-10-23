/**
 * Абстрактный класс для боевой системы с Template Method
 */
public abstract class BattleSystem {
    
    public final boolean fight(Hero hero, Monster monster) {
        System.out.println("\n=== НАЧАЛО БОЯ ===");
        System.out.println("Герой: " + hero.getName() + " (HP: " + hero.getHealth() + ")");
        System.out.println("Монстр: " + monster.getName() + " (HP: " + monster.getHealth() + ")");
        
        if (!preBattleCheck(hero, monster)) {
            return false;
        }
        
        // Основной цикл боя
        while (hero.isAlive() && monster.isAlive()) {
            // Ход героя
            heroTurn(hero, monster);
            if (!monster.isAlive()) {
                break;
            }
            
            // Ход монстра
            monsterTurn(hero, monster);
            if (!hero.isAlive()) {
                break;
            }
        }
        
        // Завершение боя
        return postBattle(hero, monster);
    }
    
    protected boolean preBattleCheck(Hero hero, Monster monster) {
        if (!hero.isAlive()) {
            System.out.println("Герой мертв! Бой невозможен.");
            return false;
        }
        if (!monster.isAlive()) {
            System.out.println("Монстр уже мертв!");
            return false;
        }
        return true;
    }
    
    protected void heroTurn(Hero hero, Monster monster) {
        System.out.println("\n--- Ход героя ---");
        hero.attack(monster);
    }
    
    protected void monsterTurn(Hero hero, Monster monster) {
        System.out.println("\n--- Ход монстра ---");
        monster.attack(hero);
    }
    
    protected boolean postBattle(Hero hero, Monster monster) {
        if (hero.isAlive()) {
            System.out.println("\n=== ПОБЕДА! ===");
            System.out.println(hero.getName() + " победил " + monster.getName() + "!");
            hero.gainExperience(monster.getExperienceReward());
            hero.gainGold(monster.getGoldReward());
            System.out.println("Получено опыта: " + monster.getExperienceReward());
            System.out.println("Получено золота: " + monster.getGoldReward());
            return true;
        } else {
            System.out.println("\n=== ПОРАЖЕНИЕ! ===");
            System.out.println(hero.getName() + " погиб в бою с " + monster.getName() + "!");
            return false;
        }
    }
}
