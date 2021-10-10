package fr.uge.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Observator extends UnicastRemoteObject implements IObservator {
    private boolean modified;
    private int value;

    public Observator() throws RemoteException {
        super();
        modified = false;
        value = -1;
    }

    public void setValue(int value) throws RemoteException {
        this.value = value;
    }


    @Override
    public void update(int value) throws RemoteException {
        if (value != this.value) {
            this.modified = true;
            this.value = value;
            System.out.println("Value modified");
        }
    }

    @Override
    public String getInfo() throws RemoteException {
        return "Observator{" +
                "modified=" + modified +
                ", value=" + value +
                '}';
    }
}
