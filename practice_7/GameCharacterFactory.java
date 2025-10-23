import java.util.Random;

// конкретная фабрика для создания персонажей игры
public class GameCharacterFactory extends CharacterFactory {
    private Random random = new Random();
    
    @Override
    public Hero createHero(String heroType, String name) {
        switch (heroType.toLowerCase()) {
            case "warrior":
            case "воин":
                return new Warrior(name);
            case "mage":
            case "маг":
                return new Mage(name);
            case "archer":
            case "лучник":
                return new Archer(name);
            default:
                throw new IllegalArgumentException("Неизвестный тип героя: " + heroType);
        }
    }
    
    @Override
    public Monster createMonster(String monsterType) {
        switch (monsterType.toLowerCase()) {
            case "goblin":
            case "гоблин":
                return new Goblin();
            case "skeleton":
            case "скелет":
                return new Skeleton();
            case "dragon":
            case "дракон":
                return new Dragon();
            default:
                throw new IllegalArgumentException("Неизвестный тип монстра: " + monsterType);
        }
    }
    
    @Override
    public Monster createRandomMonster() {
        String[] monsterTypes = {"goblin", "skeleton", "dragon"};
        String randomType = monsterTypes[random.nextInt(monsterTypes.length)];
        return createMonster(randomType);
    }
}
