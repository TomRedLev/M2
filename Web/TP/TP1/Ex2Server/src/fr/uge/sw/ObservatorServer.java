package fr.uge.sw;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import static java.lang.Thread.sleep;

public class ObservatorServer {

    public static void main(String[] args) throws MalformedURLException, RemoteException, InterruptedException {
        LocateRegistry.createRegistry(1099);
        IObserved observed = new Observed();
        Naming.rebind("observed", observed);
        for (int i = 0; i < 100; i++) {
            observed.modifyValue(i);
            sleep(1000);
        }
    }
}
