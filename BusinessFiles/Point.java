package Logic;
import DataAccess.DAOs.PointDAO;
import DataAccess.DTOs.PointDTO;

public class Point {
    private String address;
    private String phone;
    private String contactName;
    private String zone;
    private String tag;
    private PointDAO pointDAO;
    public Point(String address, String phone, String contactName, String zone, String tag) {
        
        this.address = address;
        this.phone = phone;
        this.contactName = contactName;
        this.zone = zone;
        this.tag = tag;
        this.pointDAO = new PointDAO();
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
        this.pointDAO.update(this);
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
        this.pointDAO.update(this);
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
        this.pointDAO.update(this);
    }
    public String getZone() {
        return zone;
    }
    public void setZone(String zone) {
        this.zone = zone;
        this.pointDAO.update(this);
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
        this.pointDAO.update(this);
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
        if (!(o instanceof Point)) return false;
        Point that = (Point) o;
        return Object.equals(getAddress(), (that.getAddress())) && Object.equals(getPhone(), (that.getPhone())) && Object.equals(getContactName(), (that.getContactName())) && Object.equals(getZone(), (that.getZone())) && Object.equals(getTag(), (that.getTag()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getPhone(), getContactName(), getZone(), getTag());
    }
    
}
