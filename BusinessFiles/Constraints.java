package Logic;
import DataAccess.DAOs.ConstraintsDAO;
import DataAccess.DTOs.ConstraintsDTO;

public class Constraints {
    private int employeeId;
    private String date;
    private String shiftTime;
    private ConstraintsDAO constraintsDAO;
    public Constraints(int employeeId, String date, String shiftTime) {
        
        this.employeeId = employeeId;
        this.date = date;
        this.shiftTime = shiftTime;
        this.constraintsDAO = new ConstraintsDAO();
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        this.constraintsDAO.update(this);
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
        this.constraintsDAO.update(this);
    }
    public String getShiftTime() {
        return shiftTime;
    }
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
        this.constraintsDAO.update(this);
    }
    @Override
    public String toString() {
        return "Constraints{employeeId = [" + this.employeeId"], " +
        "date = [" + this.date"], " +
        "shiftTime = [" + this.shiftTime"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Constraints)) return false;
        Constraints that = (Constraints) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getDate(), getShiftTime());
    }
    
}
