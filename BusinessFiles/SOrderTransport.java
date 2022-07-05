package Logic;
import DataAccess.DAOs.OrderTransportDAO;
import DataAccess.DTOs.OrderTransportDTO;

public class OrderTransport {
    private OrderTransportDAO ordertransportDAO;
    private long orderTransportId;
    private String origin;
    private String destination;
    private String basedOnCreationTime;
    private String supplierID;
    
    public OrderTransport(long orderTransportId, String origin, String destination, String basedOnCreationTime, String supplierID) {
        this.orderTransportId = orderTransportId;
        this.origin = origin;
        this.destination = destination;
        this.basedOnCreationTime = basedOnCreationTime;
        this.supplierID = supplierID;
        this.ordertransportDAO = new OrderTransportDAO();
    }
    public long getOrderTransportId() {
        return this.orderTransportId;
    }
    public void setOrderTransportId(long orderTransportId) {
        this.orderTransportId = orderTransportId;
        this.ordertransportDAO.update(this);
    }
    public String getOrigin() {
        return this.origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
        this.ordertransportDAO.update(this);
    }
    public String getDestination() {
        return this.destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
        this.ordertransportDAO.update(this);
    }
    public String getBasedOnCreationTime() {
        return this.basedOnCreationTime;
    }
    public void setBasedOnCreationTime(String basedOnCreationTime) {
        this.basedOnCreationTime = basedOnCreationTime;
        this.ordertransportDAO.update(this);
    }
    public String getSupplierID() {
        return this.supplierID;
    }
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
        this.ordertransportDAO.update(this);
    }
    @Override
    public String toString(){
        return "OrderTransport{" +
        "orderTransportId = [" + this.orderTransportId + "], " +
        "origin = [" + this.origin + "], " +
        "destination = [" + this.destination + "], " +
        "basedOnCreationTime = [" + this.basedOnCreationTime + "], " +
        "supplierID = [" + this.supplierID + "], " +
        "}";
    }
    
}
