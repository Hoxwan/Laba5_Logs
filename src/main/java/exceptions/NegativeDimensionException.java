package exceptions;

/**
 * Исключение, возникающее при отрицательных размерах.
 */
public class NegativeDimensionException extends Exception {
    public NegativeDimensionException(String message) {
        super(message);
    }
}
