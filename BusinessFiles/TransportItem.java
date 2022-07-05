package Logic;
import DataAccess.DAOs.TransportItemDAO;
import DataAccess.DTOs.TransportItemDTO;

public class TransportItem {
    private String name;
    private int quantity;
    private int orderTransportId;
    private String destinationFileId;
    private TransportItemDAO transportItemDAO;
    public TransportItem(String name, int quantity, int orderTransportId, String destinationFileId) {
        
        this.name = name;
        this.quantity = quantity;
        this.orderTransportId = orderTransportId;
        this.destinationFileId = destinationFileId;
        this.transportItemDAO = new TransportItemDAO();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        this.transportItemDAO.update(this);
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.transportItemDAO.update(this);
    }
    public int getOrderTransportId() {
        return orderTransportId;
    }
    public void setOrderTransportId(int orderTransportId) {
        this.orderTransportId = orderTransportId;
        this.transportItemDAO.update(this);
    }
    public String getDestinationFileId() {
        return destinationFileId;
    }
    public void setDestinationFileId(String destinationFileId) {
        this.destinationFileId = destinationFileId;
        this.transportItemDAO.update(this);
    }
    @Override
    public String toString() {
        return "TransportItem{name = [" + this.name"], " +
        "quantity = [" + this.quantity"], " +
        "orderTransportId = [" + this.orderTransportId"], " +
        "destinationFileId = [" + this.destinationFileId"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportItem)) return false;
        TransportItem that = (TransportItem) o;
        return Object.equals(getName(), (that.getName())) && Object.equals(getQuantity(), (that.getQuantity())) && Object.equals(getOrderTransportId(), (that.getOrderTransportId())) && Object.equals(getDestinationFileId(), (that.getDestinationFileId()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQuantity(), getOrderTransportId(), getDestinationFileId());
    }
    
}
