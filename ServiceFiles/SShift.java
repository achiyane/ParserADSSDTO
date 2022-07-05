package Service.Objects;

public class SShift {
    private String date;
    private String shiftTime;
    private String branch;
    private int shiftManager;
    public SShift(String date, String shiftTime, String branch, int shiftManager) {
        
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.shiftManager = shiftManager;
    }
    
    public SShift(Shift business) {
        this.date = business.getDate();
        this.shiftTime = business.getShiftTime();
        this.branch = business.getBranch();
        this.shiftManager = business.getShiftManager();
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
    public int getShiftManager() {
        return shiftManager;
    }
    public void setShiftManager(int shiftManager) {
        this.shiftManager = shiftManager;
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
        if (!(o instanceof SShift)) return false;
        SShift that = (SShift) o;
        return Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime())) && Object.equals(getBranch(), (that.getBranch())) && Object.equals(getShiftManager(), (that.getShiftManager()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getShiftTime(), getBranch(), getShiftManager());
    }
}
