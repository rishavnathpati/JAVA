package RMI.Addition;

import java.rmi.*;

public interface IAddition extends Remote {
    double add(double a, double b) throws RemoteException;
    
}
