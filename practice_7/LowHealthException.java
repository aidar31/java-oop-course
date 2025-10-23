/**
 * Исключение для низкого здоровья героя
 */
public class LowHealthException extends Exception {
    public LowHealthException(String message) {
        super(message);
    }
    
    public LowHealthException(String message, Throwable cause) {
        super(message, cause);
    }
}
