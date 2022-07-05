package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class TransportItemDTO extends DTO<PK> {
    private String name;
    private long quantity;
    private long orderTransportId;
    private String destinationFileId;
    
    public TransportItemDTO(String name, long quantity, long orderTransportId, String destinationFileId) {
        super(new PK(getFields(), name, orderTransportId, destinationFileId));
        
        this.name = name;
        this.quantity = quantity;
        this.orderTransportId = orderTransportId;
        this.destinationFileId = destinationFileId;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"name", "orderTransportId", "destinationFileId"}, TransportItemDTO.class);
    }
    public static PK getPK(String name, long orderTransportId, String destinationFileId) {
        return new PK(getFields(), name, orderTransportId, destinationFileId);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public long getOrderTransportId() {
        return orderTransportId;
    }
    public void setOrderTransportId(long orderTransportId) {
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
    public Object[] getValues(){
        return new Object[]{this.name, this.quantity, this.orderTransportId, this.destinationFileId};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportItemDTO)) return false;
        TransportItemDTO that = (TransportItemDTO) o;
        return Object.equals(getName(), (that.getName())) && Object.equals(getQuantity(), (that.getQuantity())) && Object.equals(getOrderTransportId(), (that.getOrderTransportId())) && Object.equals(getDestinationFileId(), (that.getDestinationFileId()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQuantity(), getOrderTransportId(), getDestinationFileId());
    }
}
