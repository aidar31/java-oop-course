import java.util.Random;

public interface AttackStrategy {
    void attack(Character attacker, Character enemy);
}


class MeleeAttack implements AttackStrategy {
    private int damage;
    public MeleeAttack(int damage) {this.damage = damage;}
    
    @Override
    public void attack(Character attacker, Character enemy) {
        int dmg = damage;
        enemy.takeDamage(dmg);
        attacker.game_observer.onEvent("[LOG] " + attacker.getName() + " нанес удар  на " + dmg + " урона");
        attacker.game_observer.onEvent(attacker.toString() + " | " + enemy.toString());
    }
}


class MagicAttack implements AttackStrategy {
    private int damage;
    private int selfDamage;
    public MagicAttack(int damage, int selfDamage) {this.damage = damage; this.selfDamage = selfDamage;}
    
    @Override
    public void attack(Character attacker, Character enemy) {
        int dmg = damage;
        enemy.takeDamage(dmg);
        attacker.takeDamage(selfDamage);
        attacker.game_observer.onEvent("[LOG] " + attacker.getName() + " МАГ нанес удар  на " + dmg + " урона");
        attacker.game_observer.onEvent(attacker.toString() + " | " + enemy.toString());
    }
}

class BowAttack implements AttackStrategy {
    private int damage;
    private int critChance; // 0-100
    public BowAttack(int damage, int critChance) { this.damage = damage; this.critChance = critChance; }

    @Override
    public void attack(Character attacker, Character enemy) {
        Random rnd = new Random();
        boolean crit = rnd.nextInt(100) < critChance;
        int dmg = crit ? damage * 2 : damage;
        enemy.takeDamage(dmg);
        attacker.game_observer.onEvent("[LOG] " + attacker.getName() + "Лучник нанес " + dmg + " урона" + (crit ? " (крит!)" : "") + ".");
        attacker.game_observer.onEvent(attacker.toString() + " | " + enemy.toString());
    }
}


