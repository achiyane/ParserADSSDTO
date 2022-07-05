package Logic;
import DataAccess.DAOs.TransportFileDAO;
import DataAccess.DTOs.TransportFileDTO;

public class TransportFile {
    private int id;
    private int started;
    private String startingDate;
    private String endDate;
    private int driverId;
    private int truckId;
    private String source;
    private int startingWeight;
    private String fromZone;
    private String toZone;
    private String comment;
    private int isFinish;
    private TransportFileDAO transportFileDAO;
    public TransportFile(int id, int started, String startingDate, String endDate, int driverId, int truckId, String source, int startingWeight, String fromZone, String toZone, String comment, int isFinish) {
        
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
        this.transportFileDAO = new TransportFileDAO();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
        this.transportFileDAO.update(this);
    }
    public int getStarted() {
        return started;
    }
    public void setStarted(int started) {
        this.started = started;
        this.transportFileDAO.update(this);
    }
    public String getStartingDate() {
        return startingDate;
    }
    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
        this.transportFileDAO.update(this);
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
        this.transportFileDAO.update(this);
    }
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
        this.transportFileDAO.update(this);
    }
    public int getTruckId() {
        return truckId;
    }
    public void setTruckId(int truckId) {
        this.truckId = truckId;
        this.transportFileDAO.update(this);
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
        this.transportFileDAO.update(this);
    }
    public int getStartingWeight() {
        return startingWeight;
    }
    public void setStartingWeight(int startingWeight) {
        this.startingWeight = startingWeight;
        this.transportFileDAO.update(this);
    }
    public String getFromZone() {
        return fromZone;
    }
    public void setFromZone(String fromZone) {
        this.fromZone = fromZone;
        this.transportFileDAO.update(this);
    }
    public String getToZone() {
        return toZone;
    }
    public void setToZone(String toZone) {
        this.toZone = toZone;
        this.transportFileDAO.update(this);
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
        this.transportFileDAO.update(this);
    }
    public int getIsFinish() {
        return isFinish;
    }
    public void setIsFinish(int isFinish) {
        this.isFinish = isFinish;
        this.transportFileDAO.update(this);
    }
    @Override
    public String toString() {
        return "TransportFile{id = [" + this.id"], " +
        "started = [" + this.started"], " +
        "startingDate = [" + this.startingDate"], " +
        "endDate = [" + this.endDate"], " +
        "driverId = [" + this.driverId"], " +
        "truckId = [" + this.truckId"], " +
        "source = [" + this.source"], " +
        "startingWeight = [" + this.startingWeight"], " +
        "fromZone = [" + this.fromZone"], " +
        "toZone = [" + this.toZone"], " +
        "comment = [" + this.comment"], " +
        "isFinish = [" + this.isFinish"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportFile)) return false;
        TransportFile that = (TransportFile) o;
        return Object.equals(getId(), (that.getId())) && Object.equals(getStarted(), (that.getStarted())) && Object.equals(getStartingDate(), (that.getStartingDate())) && Object.equals(getEndDate(), (that.getEndDate())) && Object.equals(getDriverId(), (that.getDriverId())) && Object.equals(getTruckId(), (that.getTruckId())) && Object.equals(getSource(), (that.getSource())) && Object.equals(getStartingWeight(), (that.getStartingWeight())) && Object.equals(getFromZone(), (that.getFromZone())) && Object.equals(getToZone(), (that.getToZone())) && Object.equals(getComment(), (that.getComment())) && Object.equals(getIsFinish(), (that.getIsFinish()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStarted(), getStartingDate(), getEndDate(), getDriverId(), getTruckId(), getSource(), getStartingWeight(), getFromZone(), getToZone(), getComment(), getIsFinish());
    }
    
}
