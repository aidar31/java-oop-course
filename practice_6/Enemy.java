
// Для доп задания иерархия врагов
public class Enemy extends Character {
    public Enemy(String name, int health, AttackStrategy strategy) {
        super(name, health, strategy);
    }

    @Override
    public void performAttack(Character enemy) {
        game_observer.onEvent("[LOG] " + name + " (враг) атакует...");
        super.performAttack(enemy);
    }
}
