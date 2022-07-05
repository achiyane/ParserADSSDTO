package Logic;
import DataAccess.DAOs.OrderTransportDAO;
import DataAccess.DTOs.OrderTransportDTO;

public class OrderTransport {
    private int orderTransportId;
    private String origin;
    private String destination;
    private String basedOnCreationTime;
    private String supplierID;
    private OrderTransportDAO orderTransportDAO;
    public OrderTransport(int orderTransportId, String origin, String destination, String basedOnCreationTime, String supplierID) {
        
        this.orderTransportId = orderTransportId;
        this.origin = origin;
        this.destination = destination;
        this.basedOnCreationTime = basedOnCreationTime;
        this.supplierID = supplierID;
        this.orderTransportDAO = new OrderTransportDAO();
    }
    public int getOrderTransportId() {
        return orderTransportId;
    }
    public void setOrderTransportId(int orderTransportId) {
        this.orderTransportId = orderTransportId;
        this.orderTransportDAO.update(this);
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
        this.orderTransportDAO.update(this);
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
        this.orderTransportDAO.update(this);
    }
    public String getBasedOnCreationTime() {
        return basedOnCreationTime;
    }
    public void setBasedOnCreationTime(String basedOnCreationTime) {
        this.basedOnCreationTime = basedOnCreationTime;
        this.orderTransportDAO.update(this);
    }
    public String getSupplierID() {
        return supplierID;
    }
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
        this.orderTransportDAO.update(this);
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
        if (!(o instanceof OrderTransport)) return false;
        OrderTransport that = (OrderTransport) o;
        return Object.equals(getOrderTransportId(), (that.getOrderTransportId())) && Object.equals(getOrigin(), (that.getOrigin())) && Object.equals(getDestination(), (that.getDestination())) && Object.equals(getBasedOnCreationTime(), (that.getBasedOnCreationTime())) && Object.equals(getSupplierID(), (that.getSupplierID()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getOrderTransportId(), getOrigin(), getDestination(), getBasedOnCreationTime(), getSupplierID());
    }
    
}
