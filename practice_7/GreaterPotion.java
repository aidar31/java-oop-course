// улучшенное зелье лечения (Decorator)
public class GreaterPotion extends BaseItem {
    private int healAmount;
    
    public GreaterPotion(int healAmount) {
        super("Большое зелье лечения", "Восстанавливает " + healAmount + " HP и временно увеличивает максимальное здоровье");
        this.healAmount = healAmount;
    }
    
    @Override
    public void apply(Hero hero) {
        int oldHealth = hero.getHealth();
        int oldMaxHealth = hero.getMaxHealth();
        
        // Увеличиваем максимальное здоровье на 20
        hero.maxHealth += 20;
        hero.heal(healAmount);
        
        System.out.println(hero.getName() + " выпил большое зелье лечения!");
        System.out.println("Восстановлено " + (hero.getHealth() - oldHealth) + " HP");
        System.out.println("Максимальное здоровье увеличено с " + oldMaxHealth + " до " + hero.getMaxHealth());
    }
}
