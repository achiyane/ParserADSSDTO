package Logic;
import DataAccess.DAOs.SupplierOrdersDAO;
import DataAccess.DTOs.SupplierOrdersDTO;

public class SupplierOrders {
    private int orderID;
    private String cn;
    private String supplierName;
    private String fromAddress;
    private String toAddress;
    private String date;
    private String contactPhoneNumber;
    private int transportID;
    private SupplierOrdersDAO supplierOrdersDAO;
    public SupplierOrders(int orderID, String cn, String supplierName, String fromAddress, String toAddress, String date, String contactPhoneNumber, int transportID) {
        
        this.orderID = orderID;
        this.cn = cn;
        this.supplierName = supplierName;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.date = date;
        this.contactPhoneNumber = contactPhoneNumber;
        this.transportID = transportID;
        this.supplierOrdersDAO = new SupplierOrdersDAO();
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
        this.supplierOrdersDAO.update(this);
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierOrdersDAO.update(this);
    }
    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
        this.supplierOrdersDAO.update(this);
    }
    public String getFromAddress() {
        return fromAddress;
    }
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
        this.supplierOrdersDAO.update(this);
    }
    public String getToAddress() {
        return toAddress;
    }
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
        this.supplierOrdersDAO.update(this);
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
        this.supplierOrdersDAO.update(this);
    }
    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }
    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
        this.supplierOrdersDAO.update(this);
    }
    public int getTransportID() {
        return transportID;
    }
    public void setTransportID(int transportID) {
        this.transportID = transportID;
        this.supplierOrdersDAO.update(this);
    }
    @Override
    public String toString() {
        return "SupplierOrders{orderID = [" + this.orderID"], " +
        "cn = [" + this.cn"], " +
        "supplierName = [" + this.supplierName"], " +
        "fromAddress = [" + this.fromAddress"], " +
        "toAddress = [" + this.toAddress"], " +
        "date = [" + this.date"], " +
        "contactPhoneNumber = [" + this.contactPhoneNumber"], " +
        "transportID = [" + this.transportID"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierOrders)) return false;
        SupplierOrders that = (SupplierOrders) o;
        return Object.equals(getOrderID(), (that.getOrderID())) && Object.equals(getCn(), (that.getCn())) && Object.equals(getSupplierName(), (that.getSupplierName())) && Object.equals(getFromAddress(), (that.getFromAddress())) && Object.equals(getToAddress(), (that.getToAddress())) && Object.equals(getDate(), (that.getDate())) && Object.equals(getContactPhoneNumber(), (that.getContactPhoneNumber())) && Object.equals(getTransportID(), (that.getTransportID()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getOrderID(), getCn(), getSupplierName(), getFromAddress(), getToAddress(), getDate(), getContactPhoneNumber(), getTransportID());
    }
    
}
