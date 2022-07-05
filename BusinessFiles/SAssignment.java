package Logic;
import DataAccess.DAOs.AssignmentDAO;
import DataAccess.DTOs.AssignmentDTO;

public class Assignment {
    private AssignmentDAO assignmentDAO;
    private String date;
    private String shiftTime;
    private String branch;
    private String job;
    private long capacity;
    private long quantity;
    
    public Assignment(String date, String shiftTime, String branch, String job, long capacity, long quantity) {
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.job = job;
        this.capacity = capacity;
        this.quantity = quantity;
        this.assignmentDAO = new AssignmentDAO();
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
        this.assignmentDAO.update(this);
    }
    public String getShiftTime() {
        return this.shiftTime;
    }
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
        this.assignmentDAO.update(this);
    }
    public String getBranch() {
        return this.branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
        this.assignmentDAO.update(this);
    }
    public String getJob() {
        return this.job;
    }
    public void setJob(String job) {
        this.job = job;
        this.assignmentDAO.update(this);
    }
    public long getCapacity() {
        return this.capacity;
    }
    public void setCapacity(long capacity) {
        this.capacity = capacity;
        this.assignmentDAO.update(this);
    }
    public long getQuantity() {
        return this.quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
        this.assignmentDAO.update(this);
    }
    @Override
    public String toString(){
        return "Assignment{" +
        "date = [" + this.date + "], " +
        "shiftTime = [" + this.shiftTime + "], " +
        "branch = [" + this.branch + "], " +
        "job = [" + this.job + "], " +
        "capacity = [" + this.capacity + "], " +
        "quantity = [" + this.quantity + "], " +
        "}";
    }
    
}
