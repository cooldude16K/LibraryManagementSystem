package factory;

import strategy.AuthorSearchStrategy;
import strategy.IsbnSearchStrategy;
import strategy.SearchStrategy;
import strategy.TitleSearchStrategy;

public class SearchFactory {

    public static SearchStrategy getStrategy(String type) {

        switch (type.toUpperCase()) {

            case "TITLE":
                return new TitleSearchStrategy();

            case "AUTHOR":
                return new AuthorSearchStrategy();

            case "ISBN":
                return new IsbnSearchStrategy();

            default:
                throw new IllegalArgumentException(
                        "Invalid search type"
                );
        }
    }
}