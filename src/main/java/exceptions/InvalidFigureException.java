package exceptions;

/**
 * Исключение, возникающее при недопустимых фигурах.
 */
public class InvalidFigureException extends Exception {
  public InvalidFigureException(String message) {
    super(message);
  }
}
