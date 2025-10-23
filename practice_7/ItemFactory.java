import java.util.Random;

// фабрика для создания предметов
public class ItemFactory {
    private Random random = new Random();
    
    public Item createItem(String itemType) {
        switch (itemType.toLowerCase()) {
            case "potion":
            case "зелье":
                return new Potion(30);
            case "greaterpotion":
            case "большое зелье":
                return new GreaterPotion(50);
            case "sword":
            case "меч":
                return new Sword(10);
            case "firesword":
            case "огненный меч":
                return new FireSword(15, 10);
            case "shield":
            case "щит":
                return new Shield(8);
            default:
                throw new IllegalArgumentException("Неизвестный тип предмета: " + itemType);
        }
    }

    public Item createRandomItem() {
        String[] itemTypes = {"potion", "greaterpotion", "sword", "firesword", "shield"};
        String randomType = itemTypes[random.nextInt(itemTypes.length)];
        return createItem(randomType);
    }
}
