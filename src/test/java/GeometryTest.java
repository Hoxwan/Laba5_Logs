import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import exceptions.InvalidFigureException;
import exceptions.NegativeDimensionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GeometryTest {

    @Test
    public void testCircle() throws NegativeDimensionException {
        Circle circle = new Circle(5);
        assertEquals(78.53981633974483, circle.area(), 0.0001);
        assertEquals(31.41592653589793, circle.perimeter(), 0.0001);
    }

    @Test
    public void testRectangle() throws NegativeDimensionException {
        Rectangle rectangle = new Rectangle(4, 6);
        assertEquals(24, rectangle.area());
        assertEquals(20, rectangle.perimeter());
    }

    @Test
    public void testCylinder() throws NegativeDimensionException, InvalidFigureException {
        Circle base = new Circle(5);
        Cylinder cylinder = new Cylinder(base, 10);
        assertEquals(785.3981633974483, cylinder.volume(), 0.0001);
    }

    @Test
    public void testInvalidCircle() {
        Exception exception = assertThrows(NegativeDimensionException.class, () -> new Circle(-1));
        assertEquals("Radius must be positive", exception.getMessage());
    }

    @Test
    public void testInvalidRectangle() {
        Exception exception = assertThrows(NegativeDimensionException.class, () -> new Rectangle(-1, 5));
        assertEquals("Width and height must be positive", exception.getMessage());
    }

    @Test
    public void testInvalidCylinderWithNullBase() {
        Exception exception = assertThrows(InvalidFigureException.class, () -> new Cylinder(null, 10));
        assertEquals("Base figure cannot be null", exception.getMessage());
    }

    @Test
    public void testInvalidCylinderWithNegativeHeight() {
        Exception exception = assertThrows(NegativeDimensionException.class, () -> {
            Circle base = new Circle(5);
            new Cylinder(base, -10);
        });
        assertEquals("Height must be positive", exception.getMessage());
    }
}