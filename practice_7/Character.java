/**
 * Базовый класс для всех персонажей в игре
 */
public abstract class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attack;
    protected int defense;
    protected int level;
    
    public Character(String name, int health, int attack, int defense) {
        this.name = name;
        this.maxHealth = health;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.level = 1;
    }
    
    // Абстрактный метод для атаки (Strategy pattern)
    public abstract void attack(Character target);
    
    // Метод получения урона
    public void takeDamage(int damage) {
        int actualDamage = Math.max(1, damage - defense);
        health = Math.max(0, health - actualDamage);
        
        if (health <= 0) {
            health = 0;
        }
    }
    
    // Метод лечения
    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }
    
    // Геттеры
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getLevel() { return level; }
    
    // Проверка жив ли персонаж
    public boolean isAlive() {
        return health > 0;
    }
    
    // Увеличение уровня
    public void levelUp() {
        level++;
        maxHealth += 10;
        health = maxHealth;
        attack += 5;
        defense += 2;
    }
    
    @Override
    public String toString() {
        return String.format("%s (HP: %d/%d, ATK: %d, DEF: %d, LVL: %d)", 
                           name, health, maxHealth, attack, defense, level);
    }
}
