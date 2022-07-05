package Service.Objects;

public class SPlacement {
    private String date;
    private String shiftTime;
    private String branch;
    private int employeeId;
    private String job;
    public SPlacement(String date, String shiftTime, String branch, int employeeId, String job) {
        
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.employeeId = employeeId;
        this.job = job;
    }
    
    public SPlacement(Placement business) {
        this.date = business.getDate();
        this.shiftTime = business.getShiftTime();
        this.branch = business.getBranch();
        this.employeeId = business.getEmployeeId();
        this.job = business.getJob();
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
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SPlacement)) return false;
        SPlacement that = (SPlacement) o;
        return Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime())) && Object.equals(getBranch(), (that.getBranch())) && Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getJob(), (that.getJob()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getShiftTime(), getBranch(), getEmployeeId(), getJob());
    }
}
