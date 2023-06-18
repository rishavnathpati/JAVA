package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PerfectTime extends UnicastRemoteObject implements IPerfectTime {
    public PerfectTime() throws RemoteException {
    }

    public long getPerfectTime() throws RemoteException {
        return System.currentTimeMillis();

    }
}
