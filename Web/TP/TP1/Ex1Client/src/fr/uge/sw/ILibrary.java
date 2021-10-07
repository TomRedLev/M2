package fr.uge.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ILibrary extends Remote {
    public void add(String title, long isbn, String author_name) throws RemoteException;
    public void remove(long isbn) throws RemoteException;
    public List<IBook> lookT(String search) throws RemoteException;
    public List<IBook> lookA(String search) throws RemoteException;

}
