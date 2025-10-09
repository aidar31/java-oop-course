public abstract class Character {
    protected String name;
    protected int health;
    protected AttackStrategy attack_strategy;
    // я хз там вроде не написано
    // можно по идее List Observer если много реализаций пока так
    protected GameObserver game_observer; 


    public Character(String name, int health, AttackStrategy strategy, GameObserver observer) {
        this.name = name;
        this.health = health;
        this.attack_strategy = strategy;
        this.game_observer = observer;
    }

    // геттеры 
    public String getName() { return name;}
    public int getHealth() { return health;}
    public boolean isAlive() { return health > 0;}
    
    public void takeDamage(int damage) {
        if (!isAlive()) return;
        health -= damage;
        if (health <= 0) {
            health = 0;
            // todo: вынести в отдельный метод =) 
            game_observer.onEvent("[LOG] " + name + "погиб.");
        }
    }

    @Override
    public String toString() {
        return name + " [HP=" + health + "]";
    }
}