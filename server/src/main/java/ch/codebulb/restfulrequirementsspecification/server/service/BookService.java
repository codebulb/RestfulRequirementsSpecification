package ch.codebulb.restfulrequirementsspecification.server.service;

import ch.codebulb.restfulrequirementsspecification.server.model.Book;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class BookService extends BaseService<Book> {
    @PostConstruct
    @Deprecated
    // for demo purposes only
    protected void initDemoValues() {
        try {
            save(new Book("12345-0", "Peter Pan"));
            save(new Book("12345-2", "The Jungle Book"));
            save(new Book("12345-1", "Moby Dick"));
        } catch (ConstraintViolationException ex) {
            throw new RuntimeException(ex);
        }
    }
}
