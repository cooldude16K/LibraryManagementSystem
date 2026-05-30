package model;

import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Patron extends Person implements Observer {

    private List<Loan> borrowingHistory;

    public Patron(String id, String name) {
        super(id, name);
        this.borrowingHistory = new ArrayList<>();
    }

    public List<Loan> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void addLoan(Loan loan) {
        borrowingHistory.add(loan);
    }

    @Override
    public void update(Book book) {
        System.out.println(
                getName() +
                        " notified: " +
                        book.getTitle() +
                        " is now available."
        );
    }
}