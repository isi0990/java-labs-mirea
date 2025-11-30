package prac12;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

abstract class Shape {
    protected Color color;
    protected int x, y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);
}

class Circle extends Shape {
    private int radius;

    public Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius*2, radius*2);
    }
}

class Rectangle extends Shape {
    private int width, height;

    public Rectangle(Color color, int x, int y, int w, int h) {
        super(color, x, y);
        this.width = w;
        this.height = h;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

public class RandomShapes extends JFrame {
    private Shape[] shapes = new Shape[20];

    public RandomShapes() {
        setTitle("Random Shapes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Random rand = new Random();
        for (int i = 0; i < shapes.length; i++) {
            Color color = new Color(rand.nextInt(256),
                    rand.nextInt(256),
                    rand.nextInt(256));
            if (rand.nextBoolean()) {
                shapes[i] = new Circle(color,
                        rand.nextInt(700), rand.nextInt(500),
                        rand.nextInt(50) + 20);
            } else {
                shapes[i] = new Rectangle(color,
                        rand.nextInt(700), rand.nextInt(500),
                        rand.nextInt(100) + 20,
                        rand.nextInt(100) + 20);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RandomShapes().setVisible(true);
        });
    }
}