package Logic;
import DataAccess.DAOs.PointDAO;
import DataAccess.DTOs.PointDTO;

public class Point {
    private PointDAO pointDAO;
    private String address;
    private String phone;
    private String contactName;
    private String zone;
    private String tag;
    
    public Point(String address, String phone, String contactName, String zone, String tag) {
        this.address = address;
        this.phone = phone;
        this.contactName = contactName;
        this.zone = zone;
        this.tag = tag;
        this.pointDAO = new PointDAO();
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
        this.pointDAO.update(this);
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
        this.pointDAO.update(this);
    }
    public String getContactName() {
        return this.contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
        this.pointDAO.update(this);
    }
    public String getZone() {
        return this.zone;
    }
    public void setZone(String zone) {
        this.zone = zone;
        this.pointDAO.update(this);
    }
    public String getTag() {
        return this.tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
        this.pointDAO.update(this);
    }
    @Override
    public String toString(){
        return "Point{" +
        "address = [" + this.address + "], " +
        "phone = [" + this.phone + "], " +
        "contactName = [" + this.contactName + "], " +
        "zone = [" + this.zone + "], " +
        "tag = [" + this.tag + "], " +
        "}";
    }
    
}
