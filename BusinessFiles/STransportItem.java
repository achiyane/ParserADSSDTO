package Logic;
import DataAccess.DAOs.TransportItemDAO;
import DataAccess.DTOs.TransportItemDTO;

public class TransportItem {
    private TransportItemDAO transportitemDAO;
    private String name;
    private long quantity;
    private long orderTransportId;
    private String destinationFileId;
    
    public TransportItem(String name, long quantity, long orderTransportId, String destinationFileId) {
        this.name = name;
        this.quantity = quantity;
        this.orderTransportId = orderTransportId;
        this.destinationFileId = destinationFileId;
        this.transportitemDAO = new TransportItemDAO();
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
        this.transportitemDAO.update(this);
    }
    public long getQuantity() {
        return this.quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
        this.transportitemDAO.update(this);
    }
    public long getOrderTransportId() {
        return this.orderTransportId;
    }
    public void setOrderTransportId(long orderTransportId) {
        this.orderTransportId = orderTransportId;
        this.transportitemDAO.update(this);
    }
    public String getDestinationFileId() {
        return this.destinationFileId;
    }
    public void setDestinationFileId(String destinationFileId) {
        this.destinationFileId = destinationFileId;
        this.transportitemDAO.update(this);
    }
    @Override
    public String toString(){
        return "TransportItem{" +
        "name = [" + this.name + "], " +
        "quantity = [" + this.quantity + "], " +
        "orderTransportId = [" + this.orderTransportId + "], " +
        "destinationFileId = [" + this.destinationFileId + "], " +
        "}";
    }
    
}
