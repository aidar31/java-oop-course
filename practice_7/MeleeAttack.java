// стратегия ближнего боя   
public class MeleeAttack implements AttackStrategy {
    @Override
    public void attack(Character attacker, Character target) {
        int damage = attacker.getAttack();
        System.out.println(attacker.getName() + " атакует в ближнем бою!");
        target.takeDamage(damage);
        System.out.println("Нанесено " + damage + " урона. " + 
                          target.getName() + " HP: " + target.getHealth());
    }
    
    @Override
    public String getStrategyName() {
        return "Ближний бой";
    }
}
