package Logic;
import DataAccess.DAOs.PlacementDAO;
import DataAccess.DTOs.PlacementDTO;

public class Placement {
    private PlacementDAO placementDAO;
    private String date;
    private String shiftTime;
    private String branch;
    private long employeeId;
    private String job;
    
    public Placement(String date, String shiftTime, String branch, long employeeId, String job) {
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.employeeId = employeeId;
        this.job = job;
        this.placementDAO = new PlacementDAO();
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
        this.placementDAO.update(this);
    }
    public String getShiftTime() {
        return this.shiftTime;
    }
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
        this.placementDAO.update(this);
    }
    public String getBranch() {
        return this.branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
        this.placementDAO.update(this);
    }
    public long getEmployeeId() {
        return this.employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
        this.placementDAO.update(this);
    }
    public String getJob() {
        return this.job;
    }
    public void setJob(String job) {
        this.job = job;
        this.placementDAO.update(this);
    }
    @Override
    public String toString(){
        return "Placement{" +
        "date = [" + this.date + "], " +
        "shiftTime = [" + this.shiftTime + "], " +
        "branch = [" + this.branch + "], " +
        "employeeId = [" + this.employeeId + "], " +
        "job = [" + this.job + "], " +
        "}";
    }
    
}
