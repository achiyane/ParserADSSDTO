package Logic;
import DataAccess.DAOs.ConstraintsDAO;
import DataAccess.DTOs.ConstraintsDTO;

public class Constraints {
    private ConstraintsDAO constraintsDAO;
    private long employeeId;
    private String date;
    private String shiftTime;
    
    public Constraints(long employeeId, String date, String shiftTime) {
        this.employeeId = employeeId;
        this.date = date;
        this.shiftTime = shiftTime;
        this.constraintsDAO = new ConstraintsDAO();
    }
    public long getEmployeeId() {
        return this.employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
        this.constraintsDAO.update(this);
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
        this.constraintsDAO.update(this);
    }
    public String getShiftTime() {
        return this.shiftTime;
    }
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
        this.constraintsDAO.update(this);
    }
    @Override
    public String toString(){
        return "Constraints{" +
        "employeeId = [" + this.employeeId + "], " +
        "date = [" + this.date + "], " +
        "shiftTime = [" + this.shiftTime + "], " +
        "}";
    }
    
}
