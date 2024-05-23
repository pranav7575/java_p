
// Interface for shapes that can be drawn
interface Drawable {
    void draw();
}

// Interface for shapes that can be resized
interface Resizable {
    void resize(double factor);
}

// Circle class implementing both Drawable and Resizable interfaces
class Circle implements Drawable, Resizable {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to draw the circle
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }

    // Method to resize the circle
    @Override
    public void resize(double factor) {
        radius *= factor;
        System.out.println("Circle resized. New radius: " + radius);
    }
}

// Rectangle class implementing Drawable interface
class Rectangle implements Drawable {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Method to draw the rectangle
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with length " + length + " and width " + width);
    }
}

// Main class to demonstrate the shape hierarchy
public class Main {
    public static void main(String[] args) {
        // Create a circle and demonstrate drawing and resizing
        Circle circle = new Circle(5.0);
        System.out.println("Drawing circle:");
        circle.draw();
        System.out.println("Resizing circle:");
        circle.resize(1.5);

        // Create a rectangle and demonstrate drawing
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Drawing rectangle:");
        rectangle.draw();
    }
}
