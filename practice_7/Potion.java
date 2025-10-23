// Базовое зелье лечения

public class Potion extends BaseItem {
    private int healAmount;
    
    public Potion(int healAmount) {
        super("Зелье лечения", "Восстанавливает " + healAmount + " HP");
        this.healAmount = healAmount;
    }
    
    @Override
    public void apply(Hero hero) {
        int oldHealth = hero.getHealth();
        hero.heal(healAmount);
        System.out.println(hero.getName() + " выпил зелье лечения и восстановил " + 
                          (hero.getHealth() - oldHealth) + " HP!");
    }
}
