package geometry2d;

import exceptions.NegativeDimensionException;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class Rectangle implements Figure {
    private static final Logger logger = Logger.getLogger(Rectangle.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("figures.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to set up logger for Rectangle", e);
        }
    }

    private final double width;
    private final double height;

    public Rectangle(double width, double height) throws NegativeDimensionException {
        if (width <= 0 || height <= 0) {
            logger.severe("Invalid dimensions: width=" + width + ", height=" + height);
            throw new NegativeDimensionException("Width and height must be positive");
        }
        this.width = width;
        this.height = height;
        logger.info("Rectangle created with width: " + width + " and height: " + height);
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle: width=" + width + ", height=" + height + ", area=" + area() + ", perimeter=" + perimeter();
    }
}
