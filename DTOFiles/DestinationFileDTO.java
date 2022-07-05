package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class DestinationFileDTO extends DTO<PK> {
    private String id;
    private String source;
    private String destination;
    private long isDone;
    private String creationBased;
    private String arrivalDate;
    private long transportId;
    private String supplierID;
    
    public DestinationFileDTO(String id, String source, String destination, long isDone, String creationBased, String arrivalDate, long transportId, String supplierID) {
        super(new PK(getFields(), id));
        
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.isDone = isDone;
        this.creationBased = creationBased;
        this.arrivalDate = arrivalDate;
        this.transportId = transportId;
        this.supplierID = supplierID;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"id"}, DestinationFileDTO.class);
    }
    public static PK getPK(String id) {
        return new PK(getFields(), id);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public long getIsDone() {
        return isDone;
    }
    public void setIsDone(long isDone) {
        this.isDone = isDone;
    }
    public String getCreationBased() {
        return creationBased;
    }
    public void setCreationBased(String creationBased) {
        this.creationBased = creationBased;
    }
    public String getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    public long getTransportId() {
        return transportId;
    }
    public void setTransportId(long transportId) {
        this.transportId = transportId;
    }
    public String getSupplierID() {
        return supplierID;
    }
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }
    @Override
    public String toString() {
        return "DestinationFile{id = [" + this.id"], " +
        "source = [" + this.source"], " +
        "destination = [" + this.destination"], " +
        "isDone = [" + this.isDone"], " +
        "creationBased = [" + this.creationBased"], " +
        "arrivalDate = [" + this.arrivalDate"], " +
        "transportId = [" + this.transportId"], " +
        "supplierID = [" + this.supplierID"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.id, this.source, this.destination, this.isDone, this.creationBased, this.arrivalDate, this.transportId, this.supplierID};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DestinationFileDTO)) return false;
        DestinationFileDTO that = (DestinationFileDTO) o;
        return Object.equals(getId(), (that.getId())) && Object.equals(getSource(), (that.getSource())) && Object.equals(getDestination(), (that.getDestination())) && Object.equals(getIsDone(), (that.getIsDone())) && Object.equals(getCreationBased(), (that.getCreationBased())) && Object.equals(getArrivalDate(), (that.getArrivalDate())) && Object.equals(getTransportId(), (that.getTransportId())) && Object.equals(getSupplierID(), (that.getSupplierID()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSource(), getDestination(), getIsDone(), getCreationBased(), getArrivalDate(), getTransportId(), getSupplierID());
    }
}
