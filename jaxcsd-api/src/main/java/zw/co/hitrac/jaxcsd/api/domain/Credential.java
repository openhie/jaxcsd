package zw.co.hitrac.jaxcsd.api.domain;

import java.util.Date;
import zw.co.hitrac.jaxcsd.api.marshal.CredentialMarshaler;
import zw.co.hitrac.jaxcsd.api.marshal.Marshaler;

/**
 *
 * @author Charles Chigoriwa
 */
public class Credential implements CsdMarshalable {

    private CodedType codedType;
    private String number;
    private String issuingAuthority;
    private Date credentialIssueDate;
    private Date credentialRenewalDate;
    private Marshaler<Credential> marshaler = CredentialMarshaler.get();

    public Credential() {
    }

    public Credential(CodedType codedType, String number) {
        this(codedType, number, null, null, null);
    }

    public Credential(CodedType codedType, String number, String issuingAuthority, Date credentialIssueDate, Date credentialRenewalDate) {
        this.codedType = codedType;
        this.number = number;
        this.issuingAuthority = issuingAuthority;
        this.credentialIssueDate = credentialIssueDate;
        this.credentialRenewalDate = credentialRenewalDate;
    }

    public CodedType getCodedType() {
        return codedType;
    }

    public void setCodedType(CodedType codedType) {
        this.codedType = codedType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public Date getCredentialIssueDate() {
        return credentialIssueDate;
    }

    public void setCredentialIssueDate(Date credentialIssueDate) {
        this.credentialIssueDate = credentialIssueDate;
    }

    public Date getCredentialRenewalDate() {
        return credentialRenewalDate;
    }

    public void setCredentialRenewalDate(Date credentialRenewalDate) {
        this.credentialRenewalDate = credentialRenewalDate;
    }

    public String marshal() {
        return marshaler.marshal(this);
    }

    public String marshal(String elementName) {
        return marshaler.marshal(this, elementName);
    }

    public Marshaler<Credential> getMarshaler() {
        return marshaler;
    }

    public void setMarshaler(Marshaler<Credential> marshaler) {
        this.marshaler = marshaler;
    }
}
