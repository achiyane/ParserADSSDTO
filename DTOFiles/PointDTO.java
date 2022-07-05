package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class PointDTO extends DTO<PK> {
    private String address;
    private String phone;
    private String contactName;
    private String zone;
    private String tag;
    
    public PointDTO(String address, String phone, String contactName, String zone, String tag) {
        super(new PK(getFields(), address));
        
        this.address = address;
        this.phone = phone;
        this.contactName = contactName;
        this.zone = zone;
        this.tag = tag;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"address"}, PointDTO.class);
    }
    public static PK getPK(String address) {
        return new PK(getFields(), address);
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getZone() {
        return zone;
    }
    public void setZone(String zone) {
        this.zone = zone;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    @Override
    public String toString() {
        return "Point{address = [" + this.address"], " +
        "phone = [" + this.phone"], " +
        "contactName = [" + this.contactName"], " +
        "zone = [" + this.zone"], " +
        "tag = [" + this.tag"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.address, this.phone, this.contactName, this.zone, this.tag};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointDTO)) return false;
        PointDTO that = (PointDTO) o;
        return Object.equals(getAddress(), (that.getAddress())) && Object.equals(getPhone(), (that.getPhone())) && Object.equals(getContactName(), (that.getContactName())) && Object.equals(getZone(), (that.getZone())) && Object.equals(getTag(), (that.getTag()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getPhone(), getContactName(), getZone(), getTag());
    }
}
