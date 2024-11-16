package geometry2d;

import exceptions.NegativeDimensionException;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class Circle implements Figure {
    private static final Logger logger = Logger.getLogger(Circle.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("figures.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.SEVERE);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to set up logger for Circle", e);
        }
    }

    private final double radius;

    public Circle(double radius) throws NegativeDimensionException {
        if (radius <= 0) {
            logger.severe("Invalid radius: " + radius);
            throw new NegativeDimensionException("Radius must be positive");
        }
        this.radius = radius;
        logger.info("Circle created with radius: " + radius);
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle: radius=" + radius + ", area=" + area() + ", perimeter=" + perimeter();
    }
}
