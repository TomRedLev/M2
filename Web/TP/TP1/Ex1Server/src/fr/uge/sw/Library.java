package fr.uge.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library extends UnicastRemoteObject implements ILibrary {

    private HashMap<Long, Book> hm = new HashMap<>();

    public Library() throws RemoteException {
        super();
    }

    @Override
    public void add(String title, long isbn, String author_name) throws RemoteException {
        var book = new Book(title, isbn, author_name);
        hm.put(isbn, book);
    }

    @Override
    public void remove(long isbn) throws RemoteException {
        hm.remove(isbn);
    }

    @Override
    public List<IBook> lookT(String search) throws RemoteException {
        List<IBook> books = new ArrayList<>();
        for (var key : hm.keySet()) {
            IBook book = hm.get(key);
            if (book.getTitle().equals(search)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<IBook> lookA(String search) throws RemoteException {
        List<IBook> books = new ArrayList<>();
        for (var key : hm.keySet()) {
            IBook book = hm.get(key);
            if (book.getAuthor_name().equals(search)) {
                books.add(book);
            }
        }
        return books;
    }
}
