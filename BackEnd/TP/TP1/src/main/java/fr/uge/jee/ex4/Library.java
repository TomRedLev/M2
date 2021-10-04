package fr.uge.jee.ex4;

import java.util.Set;

public class Library {
    private Set<Book> books;

    public Library(Set<Book> books){
        this.books = books;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var book : books) {
            sb.append(book);
            sb.append("\n");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
