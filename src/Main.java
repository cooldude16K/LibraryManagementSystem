import model.Book;
import model.Patron;
import repository.BookRepository;
import repository.PatronRepository;
import service.BookService;
import service.LendingService;
import service.PatronService;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    BookRepository bookRepository = new BookRepository();
    PatronRepository patronRepository = new PatronRepository();

    BookService bookService =
            new BookService(bookRepository);

    PatronService patronService =
            new PatronService(patronRepository);

    LendingService lendingService =
            new LendingService(
                    bookRepository,
                    patronRepository
            );

    // Add Books
    Book book1 = new Book(
            "101",
            "Effective Java",
            "Joshua Bloch",
            2018
    );

    Book book2 = new Book(
            "102",
            "Clean Code",
            "Robert Martin",
            2008
    );

    bookService.addBook(book1);
    bookService.addBook(book2);

    // Add Patrons
    Patron patron1 =
            new Patron("P101", "Kartik");

    Patron patron2 =
            new Patron("P102", "Rahul");

    patronService.addPatron(patron1);
    patronService.addPatron(patron2);

    // Checkout Book
    lendingService.checkoutBook(
            "102",
            "P101"
    );

    // Reserve Book
    lendingService.reserveBook(
            "102",
            "P102"
    );

    // Return Book
    lendingService.returnBook("102");

    // Search By Title
    List<Book> books =
            bookService.searchBooks(
                    "TITLE",
                    "Java"
            );

    System.out.println("\nSearch Results:");

    for (Book book : books) {
      System.out.println(
              book.getTitle()
      );
    }
  }
}