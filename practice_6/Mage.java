public class Mage extends Character {

    public Mage(String name, int health, AttackStrategy strategy) {
        super(name, health, strategy);
    }

    @Override
    public void performAttack(Character enemy) {
        game_observer.onEvent("[LOG] " + name + " колдует...");
        super.performAttack(enemy);
    }
}
