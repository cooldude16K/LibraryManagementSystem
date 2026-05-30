package service;
import factory.SearchFactory;
import strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.List;
import model.Book;
import repository.BookRepository;

import java.util.Collection;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public void removeBook(String isbn) {
        bookRepository.removeBook(isbn);
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public Collection<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public void updateBook(String isbn,
                           String title,
                           String author,
                           int publicationYear) {

        Book book = bookRepository.findByIsbn(isbn);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        book.setTitle(title);
        book.setAuthor(author);
        book.setPublicationYear(publicationYear);

        System.out.println("Book updated successfully");
    }

    public List<Book> searchBooks(String type, String keyword) {

        SearchStrategy strategy =
                SearchFactory.getStrategy(type);

        List<Book> books =
                new ArrayList<>(bookRepository.getAllBooks());

        return strategy.search(books, keyword);
    }
}