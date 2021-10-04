package fr.uge.jee.ex4;

public class Book {
    private String title;
    private long ref;

    public Book(String title,long ref){
        this.title = title;
        this.ref = ref;
    }

    @Override
    public String toString() {
        return title + ":" + ref;
    }
}
