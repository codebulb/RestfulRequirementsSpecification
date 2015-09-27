package ch.codebulb.restfulrequirementsspecification.server.model.hal;

public class HalLink {
    private String href;

    public HalLink() {
    }

    public HalLink(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
    
    
}
