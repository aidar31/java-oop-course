/**
 * Исключение для особой атаки дракона
 */
public class DragonFireException extends Exception {
    private int fireDamage;
    
    public DragonFireException(String message, int fireDamage) {
        super(message);
        this.fireDamage = fireDamage;
    }
    
    public DragonFireException(String message, int fireDamage, Throwable cause) {
        super(message, cause);
        this.fireDamage = fireDamage;
    }
    
    public int getFireDamage() {
        return fireDamage;
    }
}
