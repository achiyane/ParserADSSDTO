package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class AssignmentDTO extends DTO<PK> {
    private String date;
    private String shiftTime;
    private String branch;
    private String job;
    private long capacity;
    private long quantity;
    
    public AssignmentDTO(String date, String shiftTime, String branch, String job, long capacity, long quantity) {
        super(new PK(getFields(), date, shiftTime, branch, job));
        
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.job = job;
        this.capacity = capacity;
        this.quantity = quantity;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"date", "shiftTime", "branch", "job"}, AssignmentDTO.class);
    }
    public static PK getPK(String date, String shiftTime, String branch, String job) {
        return new PK(getFields(), date, shiftTime, branch, job);
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getShiftTime() {
        return shiftTime;
    }
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public long getCapacity() {
        return capacity;
    }
    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Assignment{date = [" + this.date"], " +
        "shiftTime = [" + this.shiftTime"], " +
        "branch = [" + this.branch"], " +
        "job = [" + this.job"], " +
        "capacity = [" + this.capacity"], " +
        "quantity = [" + this.quantity"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.date, this.shiftTime, this.branch, this.job, this.capacity, this.quantity};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssignmentDTO)) return false;
        AssignmentDTO that = (AssignmentDTO) o;
        return Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime())) && Object.equals(getBranch(), (that.getBranch())) && Object.equals(getJob(), (that.getJob())) && Object.equals(getCapacity(), (that.getCapacity())) && Object.equals(getQuantity(), (that.getQuantity()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getShiftTime(), getBranch(), getJob(), getCapacity(), getQuantity());
    }
}
