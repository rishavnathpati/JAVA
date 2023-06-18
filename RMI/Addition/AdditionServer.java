package RMI.Addition;

public class AdditionServer {
    public static void main(String[] args) {
        try {
            Addition add = new Addition();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("rmi://localhost:1099/AdditionServer", add);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
