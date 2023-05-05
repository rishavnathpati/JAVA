package RandomScripts;
import java.util.ArrayList;

class Inventory {
    ArrayList<Product> ProductList = new ArrayList<>();

    void addProduct(Product product) {
        ProductList.add(product);
    }

    void removeProduct(Product product) {
        ProductList.remove(product);
    }

    void updateProductPrice(int productID, double newPrice) {
        for (Product product : ProductList) {
            if (product.getProductID() == productID) {
                product.setPrice(newPrice);
            }
        }
    }

    void searchProductByCategory(Category category) {
        for (Product product : ProductList) {
            if (product.getObjc().getCategoryID() == category.getCategoryID()) {
                System.out.println(product);
            }
        }
    }

    void displayInventory() {
        for (Product product : ProductList) {
            System.out.println(product);
        }
    }

    @Override
    public String toString() {
        return "Inventory [ProductList=" + ProductList + "]";
    }
}

class Product {
    int productID;
    String name;
    double price;
    Category objc = new Category(productID, name);

    public Product(int productID, String name, double price, Category objc) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.objc = objc;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getObjc() {
        return objc;
    }

    public void setObjc(Category objc) {
        this.objc = objc;
    }

    @Override
    public String toString() {
        return "Product [productID=" + productID + ", name=" + name + ", price=" + price + ", objc=" + objc + "]";
    }

}

class Category {
    int categoryID;
    String categoryname;

    public Category(int categoryID, String categoryname) {
        this.categoryID = categoryID;
        this.categoryname = categoryname;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Override
    public String toString() {
        return "Category [categoryID=" + categoryID + ", categoryname=" + categoryname + "]";
    }

}

public class Solution {
    public static void main(String[] args) {
        Category c1 = new Category(1, "Electronics");
        Category c2 = new Category(2, "Clothing");
        Category c3 = new Category(3, "Grocery");
        Category c4 = new Category(4, "Furniture");
        Category c5 = new Category(5, "Stationary");

        Product p1 = new Product(1, "Laptop", 50000, c1);
        Product p2 = new Product(2, "Mobile", 20000, c1);
        Product p3 = new Product(3, "Shirt", 1000, c2);
        Product p4 = new Product(4, "Pant", 2000, c2);
        Product p5 = new Product(5, "Rice", 100, c3);
        Product p6 = new Product(6, "Wheat", 200, c3);
        Product p7 = new Product(7, "Table", 5000, c4);
        Product p8 = new Product(8, "Chair", 1000, c4);
        Product p9 = new Product(9, "Pen", 10, c5);
        Product p10 = new Product(10, "Pencil", 5, c5);

        Inventory i = new Inventory();
        i.addProduct(p1);
        i.addProduct(p2);
        i.addProduct(p3);
        i.addProduct(p4);
        i.addProduct(p5);
        i.addProduct(p6);
        i.addProduct(p7);
        i.addProduct(p8);
        i.addProduct(p9);
        i.addProduct(p10);

        System.out.println("List of all Inventory");
        i.displayInventory();
        System.out.println();

        System.out.println("List of all Electronics");
        i.searchProductByCategory(c1);
        System.out.println();

        System.out.println("List of all Clothing");
        i.searchProductByCategory(c2);
        System.out.println();

        System.out.println("Updating price of product with ID 1");
        i.updateProductPrice(1, 60000);
        System.out.println();

        System.out.println("Remoing product with ID 2");
        i.removeProduct(p2);
        System.out.println();

        System.out.println("List of all Inventory");
        i.displayInventory();

    }
}