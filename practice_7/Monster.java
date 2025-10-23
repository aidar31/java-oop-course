/**
 * Базовый класс для всех монстров
 */
public abstract class Monster extends Character {
    protected int experienceReward;
    protected int goldReward;
    
    public Monster(String name, int health, int attack, int defense, int expReward, int goldReward) {
        super(name, health, attack, defense);
        this.experienceReward = expReward;
        this.goldReward = goldReward;
    }
    
// Гетеры
    public int getExperienceReward() { return experienceReward; }
    public int getGoldReward() { return goldReward; }
    
    // Абстрактный метод для специальных способностей монстра
    public abstract void specialAbility(Character target);
    
    @Override
    public String toString() {
        return String.format("Monster: %s (HP: %d/%d, ATK: %d, DEF: %d) [EXP: %d, Gold: %d]", 
                           name, health, maxHealth, attack, defense, experienceReward, goldReward);
    }
}
