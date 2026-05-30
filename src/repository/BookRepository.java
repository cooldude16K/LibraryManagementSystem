package repository;

import model.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookRepository {

    private Map<String, Book> books;

    public BookRepository() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book findByIsbn(String isbn) {
        return books.get(isbn);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}