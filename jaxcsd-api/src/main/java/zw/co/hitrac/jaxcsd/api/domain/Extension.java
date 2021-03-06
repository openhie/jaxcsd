package zw.co.hitrac.jaxcsd.api.domain;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class Extension implements CsdMarshalable {

    private String type;
    private String urn;

    public Extension() {
    }

    public Extension(String type, String urn) {
        this.type = type;
        this.urn = urn;
    }

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    
}
