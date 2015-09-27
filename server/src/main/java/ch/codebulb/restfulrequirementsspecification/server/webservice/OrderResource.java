package ch.codebulb.restfulrequirementsspecification.server.webservice;

import ch.codebulb.restfulrequirementsspecification.server.model.Order;
import ch.codebulb.restfulrequirementsspecification.server.service.BaseService;
import ch.codebulb.restfulrequirementsspecification.server.service.OrderService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Path("users/{userId}/orders")
@Stateless
// Note: In this demo implementation, {userId} is ignored.
public class OrderResource extends BaseResource<Order> {
    @EJB
    private OrderService service;

    @Override
    protected BaseService<Order> getService() {
        return service;
    }
}
