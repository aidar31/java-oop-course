public abstract class Character {
    protected String name;
    protected int health;
    protected AttackStrategy attack_strategy;
    // я хз там вроде не написано
    // можно по идее List Observer если много реализаций пока так
    protected GameObserver game_observer; 


    public Character(String name, int health, AttackStrategy strategy) {
        this.name = name;
        this.health = health;
        this.attack_strategy = strategy;
        this.game_observer = new BattleLog();
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

    public void performAttack(Character enemy) {
        if (!isAlive()) {
            game_observer.onEvent("[LOG] " + name + " мертв и не может атаковать");
        }

        if (attack_strategy == null) {
            game_observer.onEvent("[LOG] " + name + "стартегии атаки нету");
        }

        attack_strategy.attack(this, enemy);
    }


    public void setAttackStrategy(AttackStrategy s) {
        this.attack_strategy = s;
        game_observer.onEvent("[LOG] " + name + "стратегия атаки сменилась)");
    }

    @Override
    public String toString() {
        return name + " [HP=" + health + "]";
    }
}