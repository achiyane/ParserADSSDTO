package Logic;
import DataAccess.DAOs.TransportFileDAO;
import DataAccess.DTOs.TransportFileDTO;

public class TransportFile {
    private TransportFileDAO transportfileDAO;
    private long id;
    private long started;
    private String startingDate;
    private String endDate;
    private long driverId;
    private long truckId;
    private String source;
    private long startingWeight;
    private String fromZone;
    private String toZone;
    private String comment;
    private long isFinish;
    
    public TransportFile(long id, long started, String startingDate, String endDate, long driverId, long truckId, String source, long startingWeight, String fromZone, String toZone, String comment, long isFinish) {
        this.id = id;
        this.started = started;
        this.startingDate = startingDate;
        this.endDate = endDate;
        this.driverId = driverId;
        this.truckId = truckId;
        this.source = source;
        this.startingWeight = startingWeight;
        this.fromZone = fromZone;
        this.toZone = toZone;
        this.comment = comment;
        this.isFinish = isFinish;
        this.transportfileDAO = new TransportFileDAO();
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
        this.transportfileDAO.update(this);
    }
    public long getStarted() {
        return this.started;
    }
    public void setStarted(long started) {
        this.started = started;
        this.transportfileDAO.update(this);
    }
    public String getStartingDate() {
        return this.startingDate;
    }
    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
        this.transportfileDAO.update(this);
    }
    public String getEndDate() {
        return this.endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
        this.transportfileDAO.update(this);
    }
    public long getDriverId() {
        return this.driverId;
    }
    public void setDriverId(long driverId) {
        this.driverId = driverId;
        this.transportfileDAO.update(this);
    }
    public long getTruckId() {
        return this.truckId;
    }
    public void setTruckId(long truckId) {
        this.truckId = truckId;
        this.transportfileDAO.update(this);
    }
    public String getSource() {
        return this.source;
    }
    public void setSource(String source) {
        this.source = source;
        this.transportfileDAO.update(this);
    }
    public long getStartingWeight() {
        return this.startingWeight;
    }
    public void setStartingWeight(long startingWeight) {
        this.startingWeight = startingWeight;
        this.transportfileDAO.update(this);
    }
    public String getFromZone() {
        return this.fromZone;
    }
    public void setFromZone(String fromZone) {
        this.fromZone = fromZone;
        this.transportfileDAO.update(this);
    }
    public String getToZone() {
        return this.toZone;
    }
    public void setToZone(String toZone) {
        this.toZone = toZone;
        this.transportfileDAO.update(this);
    }
    public String getComment() {
        return this.comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
        this.transportfileDAO.update(this);
    }
    public long getIsFinish() {
        return this.isFinish;
    }
    public void setIsFinish(long isFinish) {
        this.isFinish = isFinish;
        this.transportfileDAO.update(this);
    }
    @Override
    public String toString(){
        return "TransportFile{" +
        "id = [" + this.id + "], " +
        "started = [" + this.started + "], " +
        "startingDate = [" + this.startingDate + "], " +
        "endDate = [" + this.endDate + "], " +
        "driverId = [" + this.driverId + "], " +
        "truckId = [" + this.truckId + "], " +
        "source = [" + this.source + "], " +
        "startingWeight = [" + this.startingWeight + "], " +
        "fromZone = [" + this.fromZone + "], " +
        "toZone = [" + this.toZone + "], " +
        "comment = [" + this.comment + "], " +
        "isFinish = [" + this.isFinish + "], " +
        "}";
    }
    
}
