package org.example;

import exceptions.InvalidFigureException;
import exceptions.NegativeDimensionException;
import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.FINE);
    }

    public static void main(String[] args) throws NegativeDimensionException, InvalidFigureException {
        logger.fine("Starting the program");

        Circle circle = new Circle(5);
        System.out.println(circle);
        logger.fine("Created: " + circle);

        Rectangle rectangle = new Rectangle(4, 6);
        System.out.println(rectangle);
        logger.fine("Created: " + rectangle);

        Cylinder cylinder = new Cylinder(circle, 10);
        System.out.println(cylinder);
        logger.fine("Created: " + cylinder);
    }
}
