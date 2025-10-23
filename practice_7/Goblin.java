/**
 * Гоблин - слабый монстр
 */
public class Goblin extends Monster {
    
    public Goblin() {
        super("Гоблин", 40, 12, 5, 25, 15);
    }
    
    @Override
    public void attack(Character target) {
        System.out.println(name + " атакует!");
        target.takeDamage(attack);
        System.out.println("Нанесено " + attack + " урона. " + 
                          target.getName() + " HP: " + target.getHealth());
    }
    
    @Override
    public void specialAbility(Character target) {
        System.out.println(name + " использует способность 'Быстрая атака'!");
        target.takeDamage(attack + 5);
        System.out.println("Нанесено " + (attack + 5) + " урона. " + 
                          target.getName() + " HP: " + target.getHealth());
    }
}
