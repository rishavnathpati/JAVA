package RMI.Addition;

import java.rmi.*;
import java.rmi.server.*;

public class Addition extends UnicastRemoteObject implements IAddition {

    protected Addition() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        return a + b;
    }
}
