package Service.Objects;

public class STransportFile {
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
    public STransportFile(int id, int started, String startingDate, String endDate, int driverId, int truckId, String source, int startingWeight, String fromZone, String toZone, String comment, int isFinish) {
        
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
    }
    
    public STransportFile(TransportFile business) {
        this.id = business.getId();
        this.started = business.getStarted();
        this.startingDate = business.getStartingDate();
        this.endDate = business.getEndDate();
        this.driverId = business.getDriverId();
        this.truckId = business.getTruckId();
        this.source = business.getSource();
        this.startingWeight = business.getStartingWeight();
        this.fromZone = business.getFromZone();
        this.toZone = business.getToZone();
        this.comment = business.getComment();
        this.isFinish = business.getIsFinish();
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStarted() {
        return started;
    }
    public void setStarted(int started) {
        this.started = started;
    }
    public String getStartingDate() {
        return startingDate;
    }
    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public int getTruckId() {
        return truckId;
    }
    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public int getStartingWeight() {
        return startingWeight;
    }
    public void setStartingWeight(int startingWeight) {
        this.startingWeight = startingWeight;
    }
    public String getFromZone() {
        return fromZone;
    }
    public void setFromZone(String fromZone) {
        this.fromZone = fromZone;
    }
    public String getToZone() {
        return toZone;
    }
    public void setToZone(String toZone) {
        this.toZone = toZone;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getIsFinish() {
        return isFinish;
    }
    public void setIsFinish(int isFinish) {
        this.isFinish = isFinish;
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
        if (!(o instanceof STransportFile)) return false;
        STransportFile that = (STransportFile) o;
        return Object.equals(getId(), (that.getId())) && Object.equals(getStarted(), (that.getStarted())) && Object.equals(getStartingDate(), (that.getStartingDate())) && Object.equals(getEndDate(), (that.getEndDate())) && Object.equals(getDriverId(), (that.getDriverId())) && Object.equals(getTruckId(), (that.getTruckId())) && Object.equals(getSource(), (that.getSource())) && Object.equals(getStartingWeight(), (that.getStartingWeight())) && Object.equals(getFromZone(), (that.getFromZone())) && Object.equals(getToZone(), (that.getToZone())) && Object.equals(getComment(), (that.getComment())) && Object.equals(getIsFinish(), (that.getIsFinish()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStarted(), getStartingDate(), getEndDate(), getDriverId(), getTruckId(), getSource(), getStartingWeight(), getFromZone(), getToZone(), getComment(), getIsFinish());
    }
}
