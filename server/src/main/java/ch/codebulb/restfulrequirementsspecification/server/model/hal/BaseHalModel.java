package ch.codebulb.restfulrequirementsspecification.server.model.hal;

import ch.codebulb.restfulrequirementsspecification.server.model.BaseModel;

public class BaseHalModel extends BaseModel {
    private HalLinks _links = new HalLinks();

    public HalLinks get_links() {
        return _links;
    }

    public void set_links(HalLinks _links) {
        this._links = _links;
    }

    // Unfortunately, cannot use Map for _links  because of this bug:
    // https://java.net/jira/browse/JERSEY-551
    // TODO Change to Map implementation as soon as this bug is fixed.
    public void addLink(String rel, String uri) {
        if ("edit".equals(rel)) {
            _links.setEdit(new HalLink(uri));
            return;
        }
        throw new IllegalArgumentException("Illegal link rel: " + rel);
    }
    
    public void removeLinks() {
        _links = new HalLinks();
    }
}
