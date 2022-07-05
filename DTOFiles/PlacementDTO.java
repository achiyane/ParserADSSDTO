package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class PlacementDTO extends DTO<PK> {
    private String date;
    private String shiftTime;
    private String branch;
    private long employeeId;
    private String job;
    
    public PlacementDTO(String date, String shiftTime, String branch, long employeeId, String job) {
        super(new PK(getFields(), date, shiftTime, employeeId, branch));
        
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.employeeId = employeeId;
        this.job = job;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"date", "shiftTime", "employeeId", "branch"}, PlacementDTO.class);
    }
    public static PK getPK(String date, String shiftTime, long employeeId, String branch) {
        return new PK(getFields(), date, shiftTime, employeeId, branch);
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
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    @Override
    public String toString() {
        return "Placement{date = [" + this.date"], " +
        "shiftTime = [" + this.shiftTime"], " +
        "branch = [" + this.branch"], " +
        "employeeId = [" + this.employeeId"], " +
        "job = [" + this.job"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.date, this.shiftTime, this.branch, this.employeeId, this.job};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlacementDTO)) return false;
        PlacementDTO that = (PlacementDTO) o;
        return Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime())) && Object.equals(getBranch(), (that.getBranch())) && Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getJob(), (that.getJob()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getShiftTime(), getBranch(), getEmployeeId(), getJob());
    }
}
