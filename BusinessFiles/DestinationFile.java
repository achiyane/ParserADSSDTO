package Logic;
import DataAccess.DAOs.DestinationFileDAO;
import DataAccess.DTOs.DestinationFileDTO;

public class DestinationFile {
    private String id;
    private String source;
    private String destination;
    private int isDone;
    private String creationBased;
    private String arrivalDate;
    private int transportId;
    private String supplierID;
    private DestinationFileDAO destinationFileDAO;
    public DestinationFile(String id, String source, String destination, int isDone, String creationBased, String arrivalDate, int transportId, String supplierID) {
        
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.isDone = isDone;
        this.creationBased = creationBased;
        this.arrivalDate = arrivalDate;
        this.transportId = transportId;
        this.supplierID = supplierID;
        this.destinationFileDAO = new DestinationFileDAO();
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
        this.destinationFileDAO.update(this);
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
        this.destinationFileDAO.update(this);
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
        this.destinationFileDAO.update(this);
    }
    public int getIsDone() {
        return isDone;
    }
    public void setIsDone(int isDone) {
        this.isDone = isDone;
        this.destinationFileDAO.update(this);
    }
    public String getCreationBased() {
        return creationBased;
    }
    public void setCreationBased(String creationBased) {
        this.creationBased = creationBased;
        this.destinationFileDAO.update(this);
    }
    public String getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
        this.destinationFileDAO.update(this);
    }
    public int getTransportId() {
        return transportId;
    }
    public void setTransportId(int transportId) {
        this.transportId = transportId;
        this.destinationFileDAO.update(this);
    }
    public String getSupplierID() {
        return supplierID;
    }
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
        this.destinationFileDAO.update(this);
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
        if (!(o instanceof DestinationFile)) return false;
        DestinationFile that = (DestinationFile) o;
        return Object.equals(getId(), (that.getId())) && Object.equals(getSource(), (that.getSource())) && Object.equals(getDestination(), (that.getDestination())) && Object.equals(getIsDone(), (that.getIsDone())) && Object.equals(getCreationBased(), (that.getCreationBased())) && Object.equals(getArrivalDate(), (that.getArrivalDate())) && Object.equals(getTransportId(), (that.getTransportId())) && Object.equals(getSupplierID(), (that.getSupplierID()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSource(), getDestination(), getIsDone(), getCreationBased(), getArrivalDate(), getTransportId(), getSupplierID());
    }
    
}
