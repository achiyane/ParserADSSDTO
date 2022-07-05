package Service.Objects;

public class SSupplierOrders {
    private int orderID;
    private String cn;
    private String supplierName;
    private String fromAddress;
    private String toAddress;
    private String date;
    private String contactPhoneNumber;
    private int transportID;
    public SSupplierOrders(int orderID, String cn, String supplierName, String fromAddress, String toAddress, String date, String contactPhoneNumber, int transportID) {
        
        this.orderID = orderID;
        this.cn = cn;
        this.supplierName = supplierName;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.date = date;
        this.contactPhoneNumber = contactPhoneNumber;
        this.transportID = transportID;
    }
    
    public SSupplierOrders(SupplierOrders business) {
        this.orderID = business.getOrderID();
        this.cn = business.getCn();
        this.supplierName = business.getSupplierName();
        this.fromAddress = business.getFromAddress();
        this.toAddress = business.getToAddress();
        this.date = business.getDate();
        this.contactPhoneNumber = business.getContactPhoneNumber();
        this.transportID = business.getTransportID();
    }
    
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public String getFromAddress() {
        return fromAddress;
    }
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }
    public String getToAddress() {
        return toAddress;
    }
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }
    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }
    public int getTransportID() {
        return transportID;
    }
    public void setTransportID(int transportID) {
        this.transportID = transportID;
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
        if (!(o instanceof SSupplierOrders)) return false;
        SSupplierOrders that = (SSupplierOrders) o;
        return Object.equals(getOrderID(), (that.getOrderID())) && Object.equals(getCn(), (that.getCn())) && Object.equals(getSupplierName(), (that.getSupplierName())) && Object.equals(getFromAddress(), (that.getFromAddress())) && Object.equals(getToAddress(), (that.getToAddress())) && Object.equals(getDate(), (that.getDate())) && Object.equals(getContactPhoneNumber(), (that.getContactPhoneNumber())) && Object.equals(getTransportID(), (that.getTransportID()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getOrderID(), getCn(), getSupplierName(), getFromAddress(), getToAddress(), getDate(), getContactPhoneNumber(), getTransportID());
    }
}
