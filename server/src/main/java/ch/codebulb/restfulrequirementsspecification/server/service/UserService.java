package ch.codebulb.restfulrequirementsspecification.server.service;

import ch.codebulb.restfulrequirementsspecification.server.model.User;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class UserService extends BaseService<User> {
    @PostConstruct
    @Deprecated
    // for demo purposes only
    protected void initDemoValues() {
        try {
            save(new User("admin"));
        } catch (ConstraintViolationException ex) {
            throw new RuntimeException(ex);
        }
    }
}
