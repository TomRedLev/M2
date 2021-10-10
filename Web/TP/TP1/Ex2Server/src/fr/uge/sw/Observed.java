package fr.uge.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Observed extends UnicastRemoteObject implements IObserved {
    private List<IObservator> observators;
    private int value;

    public Observed() throws RemoteException {
        super();
        observators = new ArrayList<>();
        value = -1;
    }


    @Override
    public void modifyValue(int value) throws RemoteException {
        this.value = value;
        System.out.println("Value modified " + value);
        notifyAllObservators();
    }

    @Override
    public void addObservator(IObservator observator) throws RemoteException {
        observators.add(observator);
    }

    @Override
    public void notifyAllObservators() throws RemoteException {
        for (var observator : observators) {
            observator.update(value);
        }
    }

    @Override
    public void removeObservator(IObservator observator) throws RemoteException {
        observators.remove(observator);
    }

    @Override
    public void removeAllObservators() throws RemoteException {
        observators.removeAll(observators);
    }
}
