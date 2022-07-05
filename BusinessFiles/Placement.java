package Logic;
import DataAccess.DAOs.PlacementDAO;
import DataAccess.DTOs.PlacementDTO;

public class Placement {
    private String date;
    private String shiftTime;
    private String branch;
    private int employeeId;
    private String job;
    private PlacementDAO placementDAO;
    public Placement(String date, String shiftTime, String branch, int employeeId, String job) {
        
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.employeeId = employeeId;
        this.job = job;
        this.placementDAO = new PlacementDAO();
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
        this.placementDAO.update(this);
    }
    public String getShiftTime() {
        return shiftTime;
    }
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
        this.placementDAO.update(this);
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
        this.placementDAO.update(this);
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        this.placementDAO.update(this);
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
        this.placementDAO.update(this);
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
        if (!(o instanceof Placement)) return false;
        Placement that = (Placement) o;
        return Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime())) && Object.equals(getBranch(), (that.getBranch())) && Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getJob(), (that.getJob()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getShiftTime(), getBranch(), getEmployeeId(), getJob());
    }
    
}
