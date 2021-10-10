package fr.uge.sw;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ObservatorServer {

    public static void main(String[] args) throws MalformedURLException, RemoteException {
        LocateRegistry.createRegistry(1099);
        IObserved observed = new Observed();
        Naming.rebind("observed", observed);
    }
}
