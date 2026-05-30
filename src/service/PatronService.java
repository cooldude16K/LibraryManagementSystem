package service;

import model.Patron;
import repository.PatronRepository;

import java.util.Collection;

public class PatronService {

    private PatronRepository patronRepository;

    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public void addPatron(Patron patron) {
        patronRepository.addPatron(patron);
    }

    public void removePatron(String patronId) {
        patronRepository.removePatron(patronId);
    }

    public Patron getPatronById(String patronId) {
        return patronRepository.findById(patronId);
    }

    public Collection<Patron> getAllPatrons() {
        return patronRepository.getAllPatrons();
    }
}