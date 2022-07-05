package Logic;
import DataAccess.DAOs.ShiftDAO;
import DataAccess.DTOs.ShiftDTO;

public class Shift {
    private ShiftDAO shiftDAO;
    private String date;
    private String shiftTime;
    private String branch;
    private long shiftManager;
    
    public Shift(String date, String shiftTime, String branch, long shiftManager) {
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.shiftManager = shiftManager;
        this.shiftDAO = new ShiftDAO();
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
        this.shiftDAO.update(this);
    }
    public String getShiftTime() {
        return this.shiftTime;
    }
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
        this.shiftDAO.update(this);
    }
    public String getBranch() {
        return this.branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
        this.shiftDAO.update(this);
    }
    public long getShiftManager() {
        return this.shiftManager;
    }
    public void setShiftManager(long shiftManager) {
        this.shiftManager = shiftManager;
        this.shiftDAO.update(this);
    }
    @Override
    public String toString(){
        return "Shift{" +
        "date = [" + this.date + "], " +
        "shiftTime = [" + this.shiftTime + "], " +
        "branch = [" + this.branch + "], " +
        "shiftManager = [" + this.shiftManager + "], " +
        "}";
    }
    
}
