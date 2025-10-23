// базовый класс для предметов с реализацией Observer
public abstract class BaseItem implements Item {
    protected String name;
    protected String description;
    
    public BaseItem(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return name + ": " + description;
    }
}
