package RMI.PerfectTime;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class TimeClient {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        IPerfectTime local = (IPerfectTime) Naming.lookup("rmi://localhost:1099/PerfectTime");
        System.out.println("Local time is " + new Date(local.getPerfectTime()));
    }

}
