package fr.uge.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ObservatorClient {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        IObserved observed;
        observed = (IObserved) Naming.lookup("observed");
        IObservator observator = new Observator();
        observed.addObservator(observator);
        observed.modifyValue(2);
        System.out.println(observator.getInfo());
    }

}
