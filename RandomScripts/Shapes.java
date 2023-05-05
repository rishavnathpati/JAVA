package RandomScripts;

import java.util.Random;

// Write an inheritance hierarchy for classes Quadrilateral, Rectangle and Square. Use Quadrilateral as
// the superclass of the hierarchy. Create and use a Point class to represent the points in each shape.
// Specify the instance variables and methods for each class. The private instance variables of Quadrilateral
// should be the x-y coordinate pairs for the four endpoints of the Quadrilateral. 
// Write a program that instantiates array of objects of the classes Rectangle and Square and outputs each object’s area (except
// Quadrilateral) and perimeter. Make use of random number generator to populate the objects with data.
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class Quadrilateral {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Point getP4() {
        return p4;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }

    public double getPerimeter() {
        double perimeter = 0;
        perimeter += distance(p1, p2);
        perimeter += distance(p2, p3);
        perimeter += distance(p3, p4);
        perimeter += distance(p4, p1);

        return perimeter;
    }

    public double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }
}

class Rectangle extends Quadrilateral {
    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    public double getArea() {
        return distance(getP1(), getP2()) * distance(getP2(), getP3());
    }
}

class Square extends Rectangle {
    public Square(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    @Override
    public double getArea() {
        return Math.pow(distance(getP1(), getP2()), 2);
    }
}

public class Shapes {
    public static void main(String[] args) {
        Random random = new Random();

        Rectangle[] rectangles = new Rectangle[5];
        Square[] squares = new Square[5];

        for (int i = 0; i < 5; i++) {
            rectangles[i] = new Rectangle(
                    new Point(random.nextInt(10), random.nextInt(10)),
                    new Point(random.nextInt(10), random.nextInt(10)),
                    new Point(random.nextInt(10), random.nextInt(10)),
                    new Point(random.nextInt(10), random.nextInt(10)));

            squares[i] = new Square(
                    new Point(random.nextInt(10), random.nextInt(10)),
                    new Point(random.nextInt(10), random.nextInt(10)),
                    new Point(random.nextInt(10), random.nextInt(10)),
                    new Point(random.nextInt(10), random.nextInt(10)));

        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Rectangle " + i + " perimeter: " + rectangles[i].getPerimeter());
            System.out.println("Rectangle " + i + " area: " + rectangles[i].getArea());
            System.out.println("Square " + i + " perimeter: " + squares[i].getPerimeter());
            System.out.println("Square " + i + " area: " + squares[i].getArea());
            System.out.println();
        }
    }
}
