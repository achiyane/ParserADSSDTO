package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class SupplierOrdersDTO extends DTO<PK> {
    private long orderID;
    private String cn;
    private String supplierName;
    private String fromAddress;
    private String toAddress;
    private String date;
    private String contactPhoneNumber;
    private long transportID;
    
    public SupplierOrdersDTO(long orderID, String cn, String supplierName, String fromAddress, String toAddress, String date, String contactPhoneNumber, long transportID) {
        super(new PK(getFields(), orderID));
        
        this.orderID = orderID;
        this.cn = cn;
        this.supplierName = supplierName;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.date = date;
        this.contactPhoneNumber = contactPhoneNumber;
        this.transportID = transportID;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"orderID"}, SupplierOrdersDTO.class);
    }
    public static PK getPK(long orderID) {
        return new PK(getFields(), orderID);
    }
    public long getOrderID() {
        return orderID;
    }
    public void setOrderID(long orderID) {
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
    public long getTransportID() {
        return transportID;
    }
    public void setTransportID(long transportID) {
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
    public Object[] getValues(){
        return new Object[]{this.orderID, this.cn, this.supplierName, this.fromAddress, this.toAddress, this.date, this.contactPhoneNumber, this.transportID};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierOrdersDTO)) return false;
        SupplierOrdersDTO that = (SupplierOrdersDTO) o;
        return Object.equals(getOrderID(), (that.getOrderID())) && Object.equals(getCn(), (that.getCn())) && Object.equals(getSupplierName(), (that.getSupplierName())) && Object.equals(getFromAddress(), (that.getFromAddress())) && Object.equals(getToAddress(), (that.getToAddress())) && Object.equals(getDate(), (that.getDate())) && Object.equals(getContactPhoneNumber(), (that.getContactPhoneNumber())) && Object.equals(getTransportID(), (that.getTransportID()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getOrderID(), getCn(), getSupplierName(), getFromAddress(), getToAddress(), getDate(), getContactPhoneNumber(), getTransportID());
    }
}
