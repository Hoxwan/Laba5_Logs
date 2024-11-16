package geometry2d;

/**
 * Интерфейс для геометрических фигур.
 */
public interface Figure {
    double area();       // Метод для вычисления площади фигуры
    double perimeter();  // Метод для вычисления периметра фигуры
    String toString();   // Метод для сериализации объекта в строку
}