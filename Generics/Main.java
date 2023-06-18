package Generics;

public class Main {
    public static void main(String[] args) {

        Box<String, String> box1 = new Box<>("Apple", "Orange", 10);
        Box<String, Double> box2 = new Box<>("Mango", 5.5, 5);

        box1.displayContents();
        box1.increaseQuantity(3);
        box1.decreaseQuantity(6);
        box1.displayContents();

        box2.displayContents();
        box2.increaseQuantity(2);
        box2.decreaseQuantity(10);
        box2.displayContents();
    }
}
