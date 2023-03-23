public class TriangleDriver {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");

        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
    }
}
