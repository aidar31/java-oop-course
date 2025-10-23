import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

// простой класс для представления комнаты 
public class Room {
    private String name;
    private String description;
    private List<Monster> monsters;
    private List<Item> items;
    private boolean visited;
    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.monsters = new ArrayList<>();
        this.items = new ArrayList<>();
        this.visited = false;
    }
    
    public void addMonster(Monster monster) {
        monsters.add(monster);
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public Monster getRandomMonster() {
        if (monsters.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * monsters.size());
        return monsters.get(randomIndex);
    }
    
    public Item getRandomItem() {
        if (items.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * items.size());
        return items.get(randomIndex);
    }
    
    public Iterator<Monster> getMonsterIterator() {
        return monsters.iterator();
    }
    
    public Iterator<Item> getItemIterator() {
        return items.iterator();
    }
    
    // Геттеры
    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<Monster> getMonsters() { return monsters; }
    public List<Item> getItems() { return items; }
    public boolean isVisited() { return visited; }
    
    public void setVisited(boolean visited) { this.visited = visited; }
    
    @Override
    public String toString() {
        return name + ": " + description;
    }
}
