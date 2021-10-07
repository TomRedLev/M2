package fr.uge.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBook extends Remote {
    public void setTitle(String title) throws RemoteException;

    public void setAuthor_name(String author_name) throws RemoteException;

    public void setIsbn(long isbn) throws RemoteException;


    public String getTitle() throws RemoteException;

    public long getIsbn() throws RemoteException;

    public String getAuthor_name() throws RemoteException;
}
