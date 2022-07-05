package Logic;
import DataAccess.DAOs.ShiftDAO;
import DataAccess.DTOs.ShiftDTO;

public class Shift {
    private String date;
    private String shiftTime;
    private String branch;
    private int shiftManager;
    private ShiftDAO shiftDAO;
    public Shift(String date, String shiftTime, String branch, int shiftManager) {
        
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.shiftManager = shiftManager;
        this.shiftDAO = new ShiftDAO();
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
        this.shiftDAO.update(this);
    }
    public String getShiftTime() {
        return shiftTime;
    }
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
        this.shiftDAO.update(this);
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
        this.shiftDAO.update(this);
    }
    public int getShiftManager() {
        return shiftManager;
    }
    public void setShiftManager(int shiftManager) {
        this.shiftManager = shiftManager;
        this.shiftDAO.update(this);
    }
    @Override
    public String toString() {
        return "Shift{date = [" + this.date"], " +
        "shiftTime = [" + this.shiftTime"], " +
        "branch = [" + this.branch"], " +
        "shiftManager = [" + this.shiftManager"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shift)) return false;
        Shift that = (Shift) o;
        return Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime())) && Object.equals(getBranch(), (that.getBranch())) && Object.equals(getShiftManager(), (that.getShiftManager()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getShiftTime(), getBranch(), getShiftManager());
    }
    
}
