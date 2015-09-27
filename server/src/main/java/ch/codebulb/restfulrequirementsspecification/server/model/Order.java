package ch.codebulb.restfulrequirementsspecification.server.model;

import ch.codebulb.restfulrequirementsspecification.server.model.hal.BaseHalModel;
import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

public class Order extends BaseHalModel {
    @NotNull
    private Book book;
    @NotNull
    @Future
    private Date deliveryDate;

    public Order() {
    }

    public Order(Long id, Book book, Date deliveryDate) {
        this.book = book;
        this.deliveryDate = deliveryDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
