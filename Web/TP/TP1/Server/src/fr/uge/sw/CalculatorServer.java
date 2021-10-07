package fr.uge.sw;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {

    public static void main(String[] args) throws MalformedURLException, RemoteException, UnknownHostException {
        LocateRegistry.createRegistry(1099);
        ICalculator calculator = new Calculator();
        Naming.rebind("calculator", calculator);
    }
}
