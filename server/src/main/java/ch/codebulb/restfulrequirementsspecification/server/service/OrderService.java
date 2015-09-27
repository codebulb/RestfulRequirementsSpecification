package ch.codebulb.restfulrequirementsspecification.server.service;

import ch.codebulb.restfulrequirementsspecification.server.model.Order;
import ch.codebulb.restfulrequirementsspecification.server.util.DateUtil;
import java.util.Date;
import javax.ejb.Singleton;

@Singleton
public class OrderService extends BaseService<Order> {

    @Override
    public void delete(Long id) throws ConstraintViolationException {
        Order order = findById(id);
        if (!DateUtil.isAtLeastOneDayBefore(new Date(), order.getDeliveryDate())) {
            throw new ConstraintViolationException("Cannot delete order with order.date <= today");
        }
        super.delete(id);
    }
    
}
