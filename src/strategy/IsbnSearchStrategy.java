package strategy;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class IsbnSearchStrategy implements SearchStrategy {

    @Override
    public List<Book> search(List<Book> books, String keyword) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {

            if (book.getIsbn().equalsIgnoreCase(keyword)) {

                result.add(book);
            }
        }

        return result;
    }
}