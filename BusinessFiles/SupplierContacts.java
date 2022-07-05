package Logic;
import DataAccess.DAOs.SupplierContactsDAO;
import DataAccess.DTOs.SupplierContactsDTO;

public class SupplierContacts {
    private String cn;
    private String contactPhoneNumber;
    private String contactName;
    private String contactEmail;
    private SupplierContactsDAO supplierContactsDAO;
    public SupplierContacts(String cn, String contactPhoneNumber, String contactName, String contactEmail) {
        
        this.cn = cn;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.supplierContactsDAO = new SupplierContactsDAO();
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierContactsDAO.update(this);
    }
    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }
    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
        this.supplierContactsDAO.update(this);
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
        this.supplierContactsDAO.update(this);
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
        this.supplierContactsDAO.update(this);
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
        if (!(o instanceof SupplierContacts)) return false;
        SupplierContacts that = (SupplierContacts) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getContactPhoneNumber(), (that.getContactPhoneNumber())) && Object.equals(getContactName(), (that.getContactName())) && Object.equals(getContactEmail(), (that.getContactEmail()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getContactPhoneNumber(), getContactName(), getContactEmail());
    }
    
}
