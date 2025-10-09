public abstract class CharacterFactory {
    public abstract Character createCharacter(String name);
}


class WarriorFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        AttackStrategy s = new MeleeAttack(12);
        Character c = new Character(name, 100, s) {}; 
        return c;
    }
}

class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        AttackStrategy s = new MagicAttack(18, 4);
        return new Mage(name, 85, s);
    }
}

class ArcherFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        AttackStrategy s = new BowAttack(10, 25);
        return new Character(name, 90, s) {};
    }
}

class NecromancerFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        AttackStrategy s = new MagicAttack(14, 2);
        return new Necromancer(name, 80, s);
    }
}