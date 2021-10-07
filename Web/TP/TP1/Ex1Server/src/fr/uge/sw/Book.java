package fr.uge.sw;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Book extends UnicastRemoteObject implements IBook {
    // Pour faire passage par valeur : implementer Serializable et pas tout le reste (pas d'interface ni UnicastRemoteObject)
    // Modifier le reste qui est lié à l'interface car elle n'est plus utile
    private String title;
    private long isbn;
    private String author_name;

    public Book(String title, long isbn, String author_name) throws RemoteException {
        super();
        this.title = title;
        this.isbn = isbn;
        this.author_name = author_name;
    }

    public void setTitle(String title) throws RemoteException { this.title = title; }

    public void setAuthor_name(String author_name) throws RemoteException { this.author_name = author_name; }

    public void setIsbn(long isbn) throws RemoteException { this.isbn = isbn; }


    public String getTitle() throws RemoteException {
        return title;
    }

    public long getIsbn() throws RemoteException {
        return isbn;
    }

    public String getAuthor_name() throws RemoteException {
        return author_name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn=" + isbn +
                ", author_name='" + author_name + '\'' +
                '}';
    }
}
