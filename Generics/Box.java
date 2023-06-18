package Generics;

public class Box<T, U> {
    private T item1;
    private U item2;
    private int quantity;

    public Box(T item1, U item2, int quantity) {
        this.item1 = item1;
        this.item2 = item2;
        this.quantity = quantity;
    }

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public U getItem2() {
        return item2;
    }

    public void setItem2(U item2) {
        this.item2 = item2;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayContents() {
        System.out.println("\nBox Contents:");
        System.out.println("Item 1: " + item1);
        System.out.println("Item 2: " + item2);
        System.out.println("Quantity: " + quantity);
    }

    public void increaseQuantity(int amount) {
        quantity += amount;
        System.out.println("Increased quantity by " + amount + ".");
    }

    public void decreaseQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
            System.out.println("Decreased quantity by " + amount + ".");
        } else {
            System.out.println("Insufficient quantity to decrease by " + amount + ".");
        }
    }
}
