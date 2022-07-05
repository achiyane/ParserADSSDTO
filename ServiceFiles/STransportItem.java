package Service.Objects;

public class STransportItem {
    private String name;
    private int quantity;
    private int orderTransportId;
    private String destinationFileId;
    public STransportItem(String name, int quantity, int orderTransportId, String destinationFileId) {
        
        this.name = name;
        this.quantity = quantity;
        this.orderTransportId = orderTransportId;
        this.destinationFileId = destinationFileId;
    }
    
    public STransportItem(TransportItem business) {
        this.name = business.getName();
        this.quantity = business.getQuantity();
        this.orderTransportId = business.getOrderTransportId();
        this.destinationFileId = business.getDestinationFileId();
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getOrderTransportId() {
        return orderTransportId;
    }
    public void setOrderTransportId(int orderTransportId) {
        this.orderTransportId = orderTransportId;
    }
    public String getDestinationFileId() {
        return destinationFileId;
    }
    public void setDestinationFileId(String destinationFileId) {
        this.destinationFileId = destinationFileId;
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
        if (!(o instanceof STransportItem)) return false;
        STransportItem that = (STransportItem) o;
        return Object.equals(getName(), (that.getName())) && Object.equals(getQuantity(), (that.getQuantity())) && Object.equals(getOrderTransportId(), (that.getOrderTransportId())) && Object.equals(getDestinationFileId(), (that.getDestinationFileId()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQuantity(), getOrderTransportId(), getDestinationFileId());
    }
}
