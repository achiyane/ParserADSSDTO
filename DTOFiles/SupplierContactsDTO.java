package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class SupplierContactsDTO extends DTO<PK> {
    private String cn;
    private String contactPhoneNumber;
    private String contactName;
    private String contactEmail;
    
    public SupplierContactsDTO(String cn, String contactPhoneNumber, String contactName, String contactEmail) {
        super(new PK(getFields(), cn, contactPhoneNumber));
        
        this.cn = cn;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"cn", "contactPhoneNumber"}, SupplierContactsDTO.class);
    }
    public static PK getPK(String cn, String contactPhoneNumber) {
        return new PK(getFields(), cn, contactPhoneNumber);
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
    public Object[] getValues(){
        return new Object[]{this.cn, this.contactPhoneNumber, this.contactName, this.contactEmail};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierContactsDTO)) return false;
        SupplierContactsDTO that = (SupplierContactsDTO) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getContactPhoneNumber(), (that.getContactPhoneNumber())) && Object.equals(getContactName(), (that.getContactName())) && Object.equals(getContactEmail(), (that.getContactEmail()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getContactPhoneNumber(), getContactName(), getContactEmail());
    }
}
