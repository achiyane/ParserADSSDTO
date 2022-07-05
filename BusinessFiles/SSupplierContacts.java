package Logic;
import DataAccess.DAOs.SupplierContactsDAO;
import DataAccess.DTOs.SupplierContactsDTO;

public class SupplierContacts {
    private SupplierContactsDAO suppliercontactsDAO;
    private String cn;
    private String contactPhoneNumber;
    private String contactName;
    private String contactEmail;
    
    public SupplierContacts(String cn, String contactPhoneNumber, String contactName, String contactEmail) {
        this.cn = cn;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.suppliercontactsDAO = new SupplierContactsDAO();
    }
    public String getCn() {
        return this.cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.suppliercontactsDAO.update(this);
    }
    public String getContactPhoneNumber() {
        return this.contactPhoneNumber;
    }
    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
        this.suppliercontactsDAO.update(this);
    }
    public String getContactName() {
        return this.contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
        this.suppliercontactsDAO.update(this);
    }
    public String getContactEmail() {
        return this.contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
        this.suppliercontactsDAO.update(this);
    }
    @Override
    public String toString(){
        return "SupplierContacts{" +
        "cn = [" + this.cn + "], " +
        "contactPhoneNumber = [" + this.contactPhoneNumber + "], " +
        "contactName = [" + this.contactName + "], " +
        "contactEmail = [" + this.contactEmail + "], " +
        "}";
    }
    
}
