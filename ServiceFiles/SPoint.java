package Service.Objects;

public class SPoint {
    private String address;
    private String phone;
    private String contactName;
    private String zone;
    private String tag;
    public SPoint(String address, String phone, String contactName, String zone, String tag) {
        
        this.address = address;
        this.phone = phone;
        this.contactName = contactName;
        this.zone = zone;
        this.tag = tag;
    }
    
    public SPoint(Point business) {
        this.address = business.getAddress();
        this.phone = business.getPhone();
        this.contactName = business.getContactName();
        this.zone = business.getZone();
        this.tag = business.getTag();
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SPoint)) return false;
        SPoint that = (SPoint) o;
        return Object.equals(getAddress(), (that.getAddress())) && Object.equals(getPhone(), (that.getPhone())) && Object.equals(getContactName(), (that.getContactName())) && Object.equals(getZone(), (that.getZone())) && Object.equals(getTag(), (that.getTag()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getPhone(), getContactName(), getZone(), getTag());
    }
}
