package fr.uge.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObserved extends Remote {
    public void modifyValue(int value) throws RemoteException;
    public void addObservator(IObservator observator) throws RemoteException;
    public void notifyAllObservators() throws RemoteException;
    public void removeObservator(IObservator observator) throws RemoteException;
    public void removeAllObservators() throws RemoteException;
}
