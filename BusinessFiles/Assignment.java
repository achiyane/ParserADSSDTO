package Logic;
import DataAccess.DAOs.AssignmentDAO;
import DataAccess.DTOs.AssignmentDTO;

public class Assignment {
    private String date;
    private String shiftTime;
    private String branch;
    private String job;
    private int capacity;
    private int quantity;
    private AssignmentDAO assignmentDAO;
    public Assignment(String date, String shiftTime, String branch, String job, int capacity, int quantity) {
        
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.job = job;
        this.capacity = capacity;
        this.quantity = quantity;
        this.assignmentDAO = new AssignmentDAO();
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
        this.assignmentDAO.update(this);
    }
    public String getShiftTime() {
        return shiftTime;
    }
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
        this.assignmentDAO.update(this);
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
        this.assignmentDAO.update(this);
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
        this.assignmentDAO.update(this);
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
        this.assignmentDAO.update(this);
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.assignmentDAO.update(this);
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assignment)) return false;
        Assignment that = (Assignment) o;
        return Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime())) && Object.equals(getBranch(), (that.getBranch())) && Object.equals(getJob(), (that.getJob())) && Object.equals(getCapacity(), (that.getCapacity())) && Object.equals(getQuantity(), (that.getQuantity()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getShiftTime(), getBranch(), getJob(), getCapacity(), getQuantity());
    }
    
}
