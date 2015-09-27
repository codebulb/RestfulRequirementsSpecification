package ch.codebulb.restfulrequirementsspecification.server.model;

import ch.codebulb.restfulrequirementsspecification.server.model.hal.BaseHalModel;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book extends BaseHalModel {
    private String isbn;
    private String title;

    public Book() {
    }

    @Deprecated
    // for demo purposes only
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
