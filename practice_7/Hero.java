import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

// базовый класс для героев
public abstract class Hero extends Character {
    protected int experience;
    protected int gold;
    protected List<Item> inventory;
    protected static final int MAX_INVENTORY_SIZE = 10;
    
    public Hero(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
        this.experience = 0;
        this.gold = 0;
        this.inventory = new ArrayList<>();
    }
    
    // метод для добавления предмета в инвентарь
    public void addItem(Item item) throws InventoryFullException {
        // проверка на max size инвентаря выбрасывает исключение
        if (inventory.size() >= MAX_INVENTORY_SIZE) {
            throw new InventoryFullException("Полный инвернтарь" + MAX_INVENTORY_SIZE + " предметов.");
        }
        inventory.add(item);
    }
    
    // метод для использования предмета
    public void useItem(int index) {
        if (index >= 0 && index < inventory.size()) {
            Item item = inventory.get(index);
            item.apply(this);
            inventory.remove(index);
        }
    }
    
    // получение опыта
    public void gainExperience(int exp) {
        experience += exp;
        // проверка на повышение уровня (каждые 100 опыта)
        if (experience >= level * 100) {
            levelUp();
            System.out.println(name + " повышен уровень до " + level + "!");
        }
    }
    
    // получение золота
    public void gainGold(int amount) {
        gold += amount;
    }
    
    // Геттеры
    public int getExperience() { return experience; }
    public int getGold() { return gold; }
    public List<Item> getInventory() { return inventory; }
    
    // итератор для инвентар
    // для перебора предметов в инвентаре
    public Iterator<Item> getInventoryIterator() {
        return inventory.iterator();
    }
    
    // переопдреленеи методы toString 
    @Override
    public String toString() {
        return String.format("Hero: %s (HP: %d/%d, ATK: %d, DEF: %d, LVL: %d, EXP: %d, Gold: %d)", 
                           name, health, maxHealth, attack, defense, level, experience, gold);
    }
}
