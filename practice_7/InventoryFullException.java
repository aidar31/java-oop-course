/**
 * Исключение для переполненного инвентаря
 */
public class InventoryFullException extends Exception {
    public InventoryFullException(String message) {
        super(message);
    }
    
    public InventoryFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
