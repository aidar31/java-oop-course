public class BossEnemy extends Enemy {
    public BossEnemy(String name, int health, AttackStrategy strategy) {
        super(name, health, strategy);
    }

    @Override
    public void performAttack(Character enemy) {
        game_observer.onEvent("[LOG]" + name + "босс готовиться атаковать");
        super.performAttack(enemy);
    }

}
