package RMI.PerfectTime;

import java.rmi.*;
import java.rmi.registry.*;

public class TimeServer {
    public static void main(String[] args) throws Exception {
        try {
            PerfectTime pt = new PerfectTime();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/PerfectTime", pt);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
