package ch.codebulb.restfulrequirementsspecification.server.webservice;

import ch.codebulb.restfulrequirementsspecification.server.model.User;
import ch.codebulb.restfulrequirementsspecification.server.service.BaseService;
import ch.codebulb.restfulrequirementsspecification.server.service.UserService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Path("users")
@Stateless
public class UserResource extends BaseResource<User> {
    @EJB
    private UserService service;
    
    @Override
    protected BaseService<User> getService() {
        return service;
    }
}
