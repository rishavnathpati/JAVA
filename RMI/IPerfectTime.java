package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPerfectTime extends Remote {
    long getPerfectTime() throws RemoteException;
}
