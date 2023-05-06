
/* Develop a multithreaded program with two threads one of which (a customer) should add product name and quantity of the product into a shopping cart and terminate the process after adding five such products. 
The other thread should display the name of the product, its quantity and price and the total cost of the products. 
The latter thread should wait until the first thread has finished adding products to shopping cart. 
Show execution of the threads in a loop of a fixed number of iterations. */

package Threads;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartExecute {
    
    public static void main(String[] args) {
        // Create a new shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();
        
        // Create customer thread to add products to the cart
        CustomerThread customerThread = new CustomerThread(shoppingCart);
        
        // Create display thread to display product details
        DisplayThread displayThread = new DisplayThread(shoppingCart);
        
        // Start the threads
        customerThread.start();
        displayThread.start();
        
        // Wait for both threads to finish
        try {
            customerThread.join();
            displayThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Program completed successfully.");
    }
}

class ShoppingCart {
    private List<Product> productList = new ArrayList<>();
    
    public synchronized void addProduct(Product product) {
        if (productList.size() < 5) {
            productList.add(product);
            System.out.println("Added product: " + product.getName() + ", Quantity: " + product.getQuantity());
        } else {
            System.out.println("Shopping cart is full. Cannot add product: " + product.getName() + ", Quantity: " + product.getQuantity());
        }
    }
    
    public synchronized List<Product> getProductList() {
        return productList;
    }
}

class CustomerThread extends Thread {
    private ShoppingCart shoppingCart;
    
    public CustomerThread(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            Product product = new Product("Product " + i, i);
            shoppingCart.addProduct(product);
        }
    }
}

class DisplayThread extends Thread {
    private ShoppingCart shoppingCart;
    
    public DisplayThread(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    
    @Override
    public void run() {
        try {
            // Wait for customer thread to finish
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        List<Product> productList = shoppingCart.getProductList();
        double totalCost = 0.0;
        for (Product product : productList) {
            System.out.println("Product: " + product.getName() + ", Quantity: " + product.getQuantity() + ", Price: " + product.getPrice());
            totalCost += product.getPrice() * product.getQuantity();
        }
        System.out.println("Total cost of products: " + totalCost);
    }
}

class Product {
    private String name;
    private int quantity;
    private double price;
    
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = quantity * 10.0; // Price is calculated based on quantity
    }
    
    public String getName() {
        return name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getPrice() {
        return price;
    }
}
