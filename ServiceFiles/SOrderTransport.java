package Service.Objects;

public class SOrderTransport {
    private int orderTransportId;
    private String origin;
    private String destination;
    private String basedOnCreationTime;
    private String supplierID;
    public SOrderTransport(int orderTransportId, String origin, String destination, String basedOnCreationTime, String supplierID) {
        
        this.orderTransportId = orderTransportId;
        this.origin = origin;
        this.destination = destination;
        this.basedOnCreationTime = basedOnCreationTime;
        this.supplierID = supplierID;
    }
    
    public SOrderTransport(OrderTransport business) {
        this.orderTransportId = business.getOrderTransportId();
        this.origin = business.getOrigin();
        this.destination = business.getDestination();
        this.basedOnCreationTime = business.getBasedOnCreationTime();
        this.supplierID = business.getSupplierID();
    }
    
    public int getOrderTransportId() {
        return orderTransportId;
    }
    public void setOrderTransportId(int orderTransportId) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SOrderTransport)) return false;
        SOrderTransport that = (SOrderTransport) o;
        return Object.equals(getOrderTransportId(), (that.getOrderTransportId())) && Object.equals(getOrigin(), (that.getOrigin())) && Object.equals(getDestination(), (that.getDestination())) && Object.equals(getBasedOnCreationTime(), (that.getBasedOnCreationTime())) && Object.equals(getSupplierID(), (that.getSupplierID()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getOrderTransportId(), getOrigin(), getDestination(), getBasedOnCreationTime(), getSupplierID());
    }
}
