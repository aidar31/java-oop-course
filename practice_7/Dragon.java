/**
 * Дракон - босс монстр
 */
public class Dragon extends Monster {
    
    public Dragon() {
        super("Дракон", 200, 35, 20, 100, 100);
    }
    
    @Override
    public void attack(Character target) {
        System.out.println(name + " атакует когтями!");
        target.takeDamage(attack);
        System.out.println("Нанесено " + attack + " урона. " + 
                          target.getName() + " HP: " + target.getHealth());
    }
    
    @Override
    public void specialAbility(Character target) {
        try {
            System.out.println(name + " использует способность 'Огненное дыхание'!");
            throw new DragonFireException("Дракон извергает пламя!", 50);
        } catch (DragonFireException e) {
            System.out.println("ОГНЕННОЕ ДЫХАНИЕ! " + e.getMessage());
            target.takeDamage(e.getFireDamage());
            System.out.println("Нанесено " + e.getFireDamage() + " огненного урона. " + 
                              target.getName() + " HP: " + target.getHealth());
        }
    }
}
