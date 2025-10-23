// огненный меч (Decorator)

public class FireSword extends BaseItem {
    private int attackBonus;
    private int fireDamage;
    
    public FireSword(int attackBonus, int fireDamage) {
        super("Огненный меч", "Увеличивает атаку на " + attackBonus + " и добавляет " + fireDamage + " огненного урона");
        
        this.attackBonus = attackBonus;
        this.fireDamage = fireDamage;
    }
    
    @Override
    public void apply(Hero hero) {
        int oldAttack = hero.getAttack();
        
        hero.attack += attackBonus;

        System.out.println(hero.getName() + " взял огненный меч!");
        System.out.println("Атака увеличена с " + oldAttack + " до " + hero.getAttack());
        System.out.println("Добавлен огненный урон: " + fireDamage);
    }
}
