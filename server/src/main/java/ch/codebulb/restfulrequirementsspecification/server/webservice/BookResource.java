package ch.codebulb.restfulrequirementsspecification.server.webservice;

import ch.codebulb.restfulrequirementsspecification.server.model.Book;
import ch.codebulb.restfulrequirementsspecification.server.service.BaseService;
import ch.codebulb.restfulrequirementsspecification.server.service.BookService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Path("books")
@Stateless
public class BookResource extends BaseResource<Book> {
    @EJB
    private BookService service;

    @Override
    protected BaseService<Book> getService() {
        return service;
    }
}
