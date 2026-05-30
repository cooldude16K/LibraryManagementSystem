package service;

import model.Book;
import model.Loan;
import model.Patron;
import repository.BookRepository;
import repository.PatronRepository;

import java.util.ArrayList;
import java.util.List;

public class LendingService {

    private BookRepository bookRepository;
    private PatronRepository patronRepository;
    private List<Loan> activeLoans;

    public LendingService(BookRepository bookRepository,
                          PatronRepository patronRepository) {

        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
        this.activeLoans = new ArrayList<>();
    }

    public void checkoutBook(String isbn, String patronId) {

        Book book = bookRepository.findByIsbn(isbn);
        Patron patron = patronRepository.findById(patronId);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (patron == null) {
            System.out.println("Patron not found");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed");
            return;
        }

        Loan loan = new Loan(book, patron);

        activeLoans.add(loan);
        patron.addLoan(loan);

        book.setAvailable(false);

        System.out.println("Book checked out successfully");
    }

    public void returnBook(String isbn) {

        Loan loanToRemove = null;

        for (Loan loan : activeLoans) {

            if (loan.getBook().getIsbn().equals(isbn)) {

                loan.getBook().setAvailable(true);

                loan.returnBook();

                loan.getBook().notifyObservers();

                loanToRemove = loan;

                break;
            }
        }

        if (loanToRemove != null) {

            activeLoans.remove(loanToRemove);

            System.out.println("Book returned successfully");

        } else {

            System.out.println("No active loan found for this book");
        }
    }

    public void reserveBook(String isbn, String patronId) {

        Book book = bookRepository.findByIsbn(isbn);
        Patron patron = patronRepository.findById(patronId);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (patron == null) {
            System.out.println("Patron not found");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("Book is already available. No need to reserve.");
            return;
        }

        book.addObserver(patron);

        System.out.println("Book reserved successfully");
    }
}