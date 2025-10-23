public class Archer extends Hero {
    private AttackStrategy attackStrategy;
    
    public Archer(String name) {
        super(name, 100, 22, 12);
        this.attackStrategy = new RangedAttack();
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
        return "Archer: " + super.toString() + " [Strategy: " + attackStrategy.getStrategyName() + "]";
    }
}
