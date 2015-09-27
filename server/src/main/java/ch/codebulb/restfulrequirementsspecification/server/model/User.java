package ch.codebulb.restfulrequirementsspecification.server.model;

import ch.codebulb.restfulrequirementsspecification.server.model.hal.BaseHalModel;
import java.util.List;

public class User extends BaseHalModel {
    String name;
    private List<Order> orders;

    public User() {
    }

    @Deprecated
    // for demo purposes only
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    
}
