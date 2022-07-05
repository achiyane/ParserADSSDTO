package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class OrderTransportDTO extends DTO<PK> {
    private long orderTransportId;
    private String origin;
    private String destination;
    private String basedOnCreationTime;
    private String supplierID;
    
    public OrderTransportDTO(long orderTransportId, String origin, String destination, String basedOnCreationTime, String supplierID) {
        super(new PK(getFields(), orderTransportId));
        
        this.orderTransportId = orderTransportId;
        this.origin = origin;
        this.destination = destination;
        this.basedOnCreationTime = basedOnCreationTime;
        this.supplierID = supplierID;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"orderTransportId"}, OrderTransportDTO.class);
    }
    public static PK getPK(long orderTransportId) {
        return new PK(getFields(), orderTransportId);
    }
    public long getOrderTransportId() {
        return orderTransportId;
    }
    public void setOrderTransportId(long orderTransportId) {
        this.orderTransportId = orderTransportId;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getBasedOnCreationTime() {
        return basedOnCreationTime;
    }
    public void setBasedOnCreationTime(String basedOnCreationTime) {
        this.basedOnCreationTime = basedOnCreationTime;
    }
    public String getSupplierID() {
        return supplierID;
    }
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }
    @Override
    public String toString() {
        return "OrderTransport{orderTransportId = [" + this.orderTransportId"], " +
        "origin = [" + this.origin"], " +
        "destination = [" + this.destination"], " +
        "basedOnCreationTime = [" + this.basedOnCreationTime"], " +
        "supplierID = [" + this.supplierID"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.orderTransportId, this.origin, this.destination, this.basedOnCreationTime, this.supplierID};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderTransportDTO)) return false;
        OrderTransportDTO that = (OrderTransportDTO) o;
        return Object.equals(getOrderTransportId(), (that.getOrderTransportId())) && Object.equals(getOrigin(), (that.getOrigin())) && Object.equals(getDestination(), (that.getDestination())) && Object.equals(getBasedOnCreationTime(), (that.getBasedOnCreationTime())) && Object.equals(getSupplierID(), (that.getSupplierID()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getOrderTransportId(), getOrigin(), getDestination(), getBasedOnCreationTime(), getSupplierID());
    }
}
