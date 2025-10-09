class Minion extends Enemy {
    public Minion(String name, int health, AttackStrategy strategy) {
        super(name, health, strategy);
    }

    @Override
    public void performAttack(Character enemy) {
        super.performAttack(enemy);
    }
}