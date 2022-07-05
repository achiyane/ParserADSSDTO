package Service.Objects;

public class SDestinationFile {
    private String id;
    private String source;
    private String destination;
    private int isDone;
    private String creationBased;
    private String arrivalDate;
    private int transportId;
    private String supplierID;
    public SDestinationFile(String id, String source, String destination, int isDone, String creationBased, String arrivalDate, int transportId, String supplierID) {
        
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.isDone = isDone;
        this.creationBased = creationBased;
        this.arrivalDate = arrivalDate;
        this.transportId = transportId;
        this.supplierID = supplierID;
    }
    
    public SDestinationFile(DestinationFile business) {
        this.id = business.getId();
        this.source = business.getSource();
        this.destination = business.getDestination();
        this.isDone = business.getIsDone();
        this.creationBased = business.getCreationBased();
        this.arrivalDate = business.getArrivalDate();
        this.transportId = business.getTransportId();
        this.supplierID = business.getSupplierID();
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
    public int getIsDone() {
        return isDone;
    }
    public void setIsDone(int isDone) {
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
    public int getTransportId() {
        return transportId;
    }
    public void setTransportId(int transportId) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SDestinationFile)) return false;
        SDestinationFile that = (SDestinationFile) o;
        return Object.equals(getId(), (that.getId())) && Object.equals(getSource(), (that.getSource())) && Object.equals(getDestination(), (that.getDestination())) && Object.equals(getIsDone(), (that.getIsDone())) && Object.equals(getCreationBased(), (that.getCreationBased())) && Object.equals(getArrivalDate(), (that.getArrivalDate())) && Object.equals(getTransportId(), (that.getTransportId())) && Object.equals(getSupplierID(), (that.getSupplierID()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSource(), getDestination(), getIsDone(), getCreationBased(), getArrivalDate(), getTransportId(), getSupplierID());
    }
}
