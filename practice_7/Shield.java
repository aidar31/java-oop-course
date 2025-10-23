// Предмет щит
public class Shield extends BaseItem {
    private int defenseBonus;
    
    public Shield(int defenseBonus) {
        super("Щит", "Увеличивает защиту на " + defenseBonus);
        this.defenseBonus = defenseBonus;
    }
    
    @Override
    public void apply(Hero hero) {
        int oldDefense = hero.getDefense();
        hero.defense += defenseBonus;
        
        System.out.println(hero.getName() + " взял щит! Защита увеличена с " + 
                          oldDefense + " до " + hero.getDefense());
    }
}
