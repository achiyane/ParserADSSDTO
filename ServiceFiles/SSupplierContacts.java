package Service.Objects;

public class SSupplierContacts {
    private String cn;
    private String contactPhoneNumber;
    private String contactName;
    private String contactEmail;
    public SSupplierContacts(String cn, String contactPhoneNumber, String contactName, String contactEmail) {
        
        this.cn = cn;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }
    
    public SSupplierContacts(SupplierContacts business) {
        this.cn = business.getCn();
        this.contactPhoneNumber = business.getContactPhoneNumber();
        this.contactName = business.getContactName();
        this.contactEmail = business.getContactEmail();
    }
    
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }
    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    
    @Override
    public String toString() {
        return "SupplierContacts{cn = [" + this.cn"], " +
        "contactPhoneNumber = [" + this.contactPhoneNumber"], " +
        "contactName = [" + this.contactName"], " +
        "contactEmail = [" + this.contactEmail"],  " +
        "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SSupplierContacts)) return false;
        SSupplierContacts that = (SSupplierContacts) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getContactPhoneNumber(), (that.getContactPhoneNumber())) && Object.equals(getContactName(), (that.getContactName())) && Object.equals(getContactEmail(), (that.getContactEmail()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getContactPhoneNumber(), getContactName(), getContactEmail());
    }
}
