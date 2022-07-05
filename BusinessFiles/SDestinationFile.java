package Logic;
import DataAccess.DAOs.DestinationFileDAO;
import DataAccess.DTOs.DestinationFileDTO;

public class DestinationFile {
    private DestinationFileDAO destinationfileDAO;
    private String id;
    private String source;
    private String destination;
    private long isDone;
    private String creationBased;
    private String arrivalDate;
    private long transportId;
    private String supplierID;
    
    public DestinationFile(String id, String source, String destination, long isDone, String creationBased, String arrivalDate, long transportId, String supplierID) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.isDone = isDone;
        this.creationBased = creationBased;
        this.arrivalDate = arrivalDate;
        this.transportId = transportId;
        this.supplierID = supplierID;
        this.destinationfileDAO = new DestinationFileDAO();
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
        this.destinationfileDAO.update(this);
    }
    public String getSource() {
        return this.source;
    }
    public void setSource(String source) {
        this.source = source;
        this.destinationfileDAO.update(this);
    }
    public String getDestination() {
        return this.destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
        this.destinationfileDAO.update(this);
    }
    public long getIsDone() {
        return this.isDone;
    }
    public void setIsDone(long isDone) {
        this.isDone = isDone;
        this.destinationfileDAO.update(this);
    }
    public String getCreationBased() {
        return this.creationBased;
    }
    public void setCreationBased(String creationBased) {
        this.creationBased = creationBased;
        this.destinationfileDAO.update(this);
    }
    public String getArrivalDate() {
        return this.arrivalDate;
    }
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
        this.destinationfileDAO.update(this);
    }
    public long getTransportId() {
        return this.transportId;
    }
    public void setTransportId(long transportId) {
        this.transportId = transportId;
        this.destinationfileDAO.update(this);
    }
    public String getSupplierID() {
        return this.supplierID;
    }
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
        this.destinationfileDAO.update(this);
    }
    @Override
    public String toString(){
        return "DestinationFile{" +
        "id = [" + this.id + "], " +
        "source = [" + this.source + "], " +
        "destination = [" + this.destination + "], " +
        "isDone = [" + this.isDone + "], " +
        "creationBased = [" + this.creationBased + "], " +
        "arrivalDate = [" + this.arrivalDate + "], " +
        "transportId = [" + this.transportId + "], " +
        "supplierID = [" + this.supplierID + "], " +
        "}";
    }
    
}
