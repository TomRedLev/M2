package fr.uge.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static java.lang.Thread.sleep;

public class ObservatorClient {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException, InterruptedException {
        IObserved observed;
        observed = (IObserved) Naming.lookup("observed");
        IObservator observator = new Observator();
        observed.addObservator(observator);
        System.out.println(observator.getInfo());
        for (int i = 0; i < 100; i++) {
            System.out.println(observator.getInfo());
            sleep(1000);
        }
    }

}
