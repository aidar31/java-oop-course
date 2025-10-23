

public class Warrior extends Hero {
    private AttackStrategy attackStrategy;
    
    public Warrior(String name) {
        super(name, 120, 25, 15);
        this.attackStrategy = new MeleeAttack();
    }
    
    @Override
    public void attack(Character target) {
        attackStrategy.attack(this, target);
    }
    
    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
    }
    
    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }
    
    @Override
    public String toString() {
        return "Warrior: " + super.toString() + " [Strategy: " + attackStrategy.getStrategyName() + "]";
    }
}
