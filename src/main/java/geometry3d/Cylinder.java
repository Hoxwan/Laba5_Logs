package geometry3d;

import exceptions.InvalidFigureException;
import exceptions.NegativeDimensionException;
import geometry2d.Figure;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import java.util.logging.ConsoleHandler;

public class Cylinder {
    private static final Logger logger = Logger.getLogger(Cylinder.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("cylinder.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.FINEST);

            // Console handler for logging to console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(consoleHandler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to set up logger for Cylinder", e);
        }
    }

    private final Figure base;
    private final double height;

    public Cylinder(Figure base, double height) throws InvalidFigureException, NegativeDimensionException {
        if (base == null) {
            logger.severe("Base figure cannot be null");
            throw new InvalidFigureException("Base figure cannot be null");
        }
        if (height <= 0) {
            logger.severe("Invalid height: " + height);
            throw new NegativeDimensionException("Height must be positive");
        }
        this.base = base;
        this.height = height;
        logger.fine("Cylinder created with base: " + base + " and height: " + height);
    }

    public double volume() {
        return base.area() * height;
    }

    @Override
    public String toString() {
        return "Cylinder: base=" + base + ", height=" + height + ", volume=" + volume();
    }
}
