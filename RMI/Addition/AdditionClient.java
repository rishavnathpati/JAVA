package RMI.Addition;

public class AdditionClient {
    public static void main(String[] args) throws Exception {
        try {
            IAddition stub = (IAddition) java.rmi.Naming.lookup("rmi://localhost:1099/AdditionServer");
            System.out.println(stub.add(34, 4));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
