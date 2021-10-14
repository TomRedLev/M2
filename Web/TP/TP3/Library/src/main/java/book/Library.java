package book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {

    private HashMap<Long, Book> hm = new HashMap<>();

    public Library() {
        super();
    }

    public void add(String title, long isbn, String author_name) {
        var book = new Book(title, isbn, author_name);
        hm.put(isbn, book);
    }

    public void remove(long isbn) {
        hm.remove(isbn);
    }

    public Book[] lookT(String search) {
        List<Book> booklist = new ArrayList<>();
        for (var key : hm.values()) {
            if (key.getTitle().equals(search)) {
                booklist.add(key);
            }
        }
        Book[] bookstab = new Book[booklist.size()];
        for (int i = 0; i < booklist.size(); i++) {
        	bookstab[i] = booklist.get(i);
        }
        return bookstab;
    }

    public Book[] lookA(String search) {
    	List booklist = new ArrayList<Book>();
        for (var key : hm.values()) {
            if (key.getTitle().equals(search)) {
                booklist.add(key);
            }
        }
        Book[] bookstab = new Book[booklist.size()];
        for (int i = 0; i < booklist.size(); i++) {
        	bookstab[i] = (Book) booklist.get(i);
        }
        return bookstab;
    }
}
