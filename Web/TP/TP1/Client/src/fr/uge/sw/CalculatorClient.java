package fr.uge.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculatorClient {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        ICalculator calculator;
        calculator = (ICalculator) Naming.lookup("calculator");
        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.sub(1, 2));
        System.out.println(calculator.mul(1, 2));
        System.out.println(calculator.div(1, 2));
    }

}
