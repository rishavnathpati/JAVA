// path: Shape/Triangle.java
package Shape;

import Triangle.Triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle t = new Triangle(1, 1.5, 1);
        System.out.println("Area: " + t.getArea());
        System.out.println("Perimeter: " + t.getPerimeter());
    }
}
