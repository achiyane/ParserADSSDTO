package Logic;
import DataAccess.DAOs.SupplierOrdersDAO;
import DataAccess.DTOs.SupplierOrdersDTO;

public class SupplierOrders {
    private SupplierOrdersDAO supplierordersDAO;
    private long orderID;
    private String cn;
    private String supplierName;
    private String fromAddress;
    private String toAddress;
    private String date;
    private String contactPhoneNumber;
    private long transportID;
    
    public SupplierOrders(long orderID, String cn, String supplierName, String fromAddress, String toAddress, String date, String contactPhoneNumber, long transportID) {
        this.orderID = orderID;
        this.cn = cn;
        this.supplierName = supplierName;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.date = date;
        this.contactPhoneNumber = contactPhoneNumber;
        this.transportID = transportID;
        this.supplierordersDAO = new SupplierOrdersDAO();
    }
    public long getOrderID() {
        return this.orderID;
    }
    public void setOrderID(long orderID) {
        this.orderID = orderID;
        this.supplierordersDAO.update(this);
    }
    public String getCn() {
        return this.cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierordersDAO.update(this);
    }
    public String getSupplierName() {
        return this.supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
        this.supplierordersDAO.update(this);
    }
    public String getFromAddress() {
        return this.fromAddress;
    }
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
        this.supplierordersDAO.update(this);
    }
    public String getToAddress() {
        return this.toAddress;
    }
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
        this.supplierordersDAO.update(this);
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
        this.supplierordersDAO.update(this);
    }
    public String getContactPhoneNumber() {
        return this.contactPhoneNumber;
    }
    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
        this.supplierordersDAO.update(this);
    }
    public long getTransportID() {
        return this.transportID;
    }
    public void setTransportID(long transportID) {
        this.transportID = transportID;
        this.supplierordersDAO.update(this);
    }
    @Override
    public String toString(){
        return "SupplierOrders{" +
        "orderID = [" + this.orderID + "], " +
        "cn = [" + this.cn + "], " +
        "supplierName = [" + this.supplierName + "], " +
        "fromAddress = [" + this.fromAddress + "], " +
        "toAddress = [" + this.toAddress + "], " +
        "date = [" + this.date + "], " +
        "contactPhoneNumber = [" + this.contactPhoneNumber + "], " +
        "transportID = [" + this.transportID + "], " +
        "}";
    }
    
}
