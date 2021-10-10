package fr.uge.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObservator extends Remote {
    public void update(int value) throws RemoteException;
    public String getInfo() throws RemoteException;
    public void setValue(int value) throws RemoteException;
}
