package book;


public class Book {
    // Pour faire passage par valeur : implementer Serializable et pas tout le reste (pas d'interface ni UnicastRemoteObject)
    // Modifier le reste qui est lié à l'interface car elle n'est plus utile
    private String title;
    private long isbn;
    private String author_name;

    public Book(String title, long isbn, String author_name) {
        super();
        this.title = title;
        this.isbn = isbn;
        this.author_name = author_name;
    }

    public void setTitle(String title) { this.title = title; }

    public void setAuthor_name(String author_name) { this.author_name = author_name; }

    public void setIsbn(long isbn) { this.isbn = isbn; }


    public String getTitle() {
        return title;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getAuthor_name() {
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
