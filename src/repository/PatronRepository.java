package repository;

import model.Patron;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PatronRepository {

    private Map<String, Patron> patrons;

    public PatronRepository() {
        patrons = new HashMap<>();
    }

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public Patron findById(String patronId) {
        return patrons.get(patronId);
    }

    public void removePatron(String patronId) {
        patrons.remove(patronId);
    }

    public Collection<Patron> getAllPatrons() {
        return patrons.values();
    }
}