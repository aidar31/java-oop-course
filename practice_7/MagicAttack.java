// Стратегия магической атаки

public class MagicAttack implements AttackStrategy {
    @Override
    public void attack(Character attacker, Character target) {
        int damage = attacker.getAttack() + 10; // Магия наносит больше урона
        System.out.println(attacker.getName() + " использует магическую атаку!");
        target.takeDamage(damage);
        System.out.println("Нанесено " + damage + " магического урона. " + 
                          target.getName() + " HP: " + target.getHealth());
    }
    
    @Override
    public String getStrategyName() {
        return "Магическая атака";
    }
}
