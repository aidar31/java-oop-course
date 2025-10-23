

public class Skeleton extends Monster {
    
    public Skeleton() {
        super("Скелет", 60, 18, 8, 40, 25);
    }
    
    @Override
    public void attack(Character target) {
        System.out.println(name + " атакует костями!");

        target.takeDamage(attack);

        System.out.println("Нанесено " + attack + " урона. " + 
                          target.getName() + " HP: " + target.getHealth());
    }
    
    @Override
    public void specialAbility(Character target) {
        System.out.println(name + " использует способность 'Костяной дождь'!");

        target.takeDamage(attack + 8);

        System.out.println("Нанесено " + (attack + 8) + " урона. " + 
                          target.getName() + " HP: " + target.getHealth());
    }
}
