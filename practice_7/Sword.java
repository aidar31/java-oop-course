/**
 * Простой меч 
 */
public class Sword extends BaseItem {
    private int attackBonus;
    
    public Sword(int attackBonus) {
        super("Меч", "Увеличивает атаку на " + attackBonus);
        this.attackBonus = attackBonus;
    }
    
    @Override
    public void apply(Hero hero) {
        int oldAttack = hero.getAttack();
        hero.attack += attackBonus;

        System.out.println(hero.getName() + " взял меч! Атака увеличена с " + 
                          oldAttack + " до " + hero.getAttack());
    }
}
