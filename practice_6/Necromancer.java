public class Necromancer extends Mage {

    public Necromancer(String name, int health, AttackStrategy strategy) {
        super(name, health, strategy);
    }

    // послет ого как нанесет урон реегенится
    @Override
    public void performAttack(Character enemy) {
        // атакуем 
        super.performAttack(enemy);
        // регентися некромант же 
        if (isAlive()) {
            int heal = 3;
            health += heal;
            game_observer.onEvent("[LOG] " + name + " некромант регенит здоровье " + heal + " HP");
        }
    }
}
