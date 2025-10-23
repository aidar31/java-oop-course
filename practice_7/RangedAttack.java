// Стратегия дальнего боя
 
public class RangedAttack implements AttackStrategy {
  
    @Override
    public void attack(Character attacker, Character target) {
        int damage = attacker.getAttack() + 5; 
  
        System.out.println(attacker.getName() + " атакует издалека!");
  
        target.takeDamage(damage);
  
        System.out.println("Нанесено " + damage + " урона. " + 
                          target.getName() + " HP: " + target.getHealth());
    }
    
    @Override
    public String getStrategyName() {
        return "Дальний бой";
    }
}
