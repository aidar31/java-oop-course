// маг - герой магического боя
public class Mage extends Hero {
    private AttackStrategy attackStrategy;
    
    public Mage(String name) {
        super(name, 80, 30, 8);
        this.attackStrategy = new MagicAttack();
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
        return "Mage: " + super.toString() + " [Strategy: " + attackStrategy.getStrategyName() + "]";
    }
}
