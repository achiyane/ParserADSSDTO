package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class TransportFileDTO extends DTO<PK> {
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
    
    public TransportFileDTO(long id, long started, String startingDate, String endDate, long driverId, long truckId, String source, long startingWeight, String fromZone, String toZone, String comment, long isFinish) {
        super(new PK(getFields(), id));
        
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
    public static Field[] getFields(){
        return getFields(new String[]{"id"}, TransportFileDTO.class);
    }
    public static PK getPK(long id) {
        return new PK(getFields(), id);
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getStarted() {
        return started;
    }
    public void setStarted(long started) {
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
    public long getDriverId() {
        return driverId;
    }
    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }
    public long getTruckId() {
        return truckId;
    }
    public void setTruckId(long truckId) {
        this.truckId = truckId;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public long getStartingWeight() {
        return startingWeight;
    }
    public void setStartingWeight(long startingWeight) {
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
    public long getIsFinish() {
        return isFinish;
    }
    public void setIsFinish(long isFinish) {
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
    public Object[] getValues(){
        return new Object[]{this.id, this.started, this.startingDate, this.endDate, this.driverId, this.truckId, this.source, this.startingWeight, this.fromZone, this.toZone, this.comment, this.isFinish};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportFileDTO)) return false;
        TransportFileDTO that = (TransportFileDTO) o;
        return Object.equals(getId(), (that.getId())) && Object.equals(getStarted(), (that.getStarted())) && Object.equals(getStartingDate(), (that.getStartingDate())) && Object.equals(getEndDate(), (that.getEndDate())) && Object.equals(getDriverId(), (that.getDriverId())) && Object.equals(getTruckId(), (that.getTruckId())) && Object.equals(getSource(), (that.getSource())) && Object.equals(getStartingWeight(), (that.getStartingWeight())) && Object.equals(getFromZone(), (that.getFromZone())) && Object.equals(getToZone(), (that.getToZone())) && Object.equals(getComment(), (that.getComment())) && Object.equals(getIsFinish(), (that.getIsFinish()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStarted(), getStartingDate(), getEndDate(), getDriverId(), getTruckId(), getSource(), getStartingWeight(), getFromZone(), getToZone(), getComment(), getIsFinish());
    }
}
