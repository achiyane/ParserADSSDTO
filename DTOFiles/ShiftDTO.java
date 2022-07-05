package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class ShiftDTO extends DTO<PK> {
    private String date;
    private String shiftTime;
    private String branch;
    private long shiftManager;
    
    public ShiftDTO(String date, String shiftTime, String branch, long shiftManager) {
        super(new PK(getFields(), date, shiftTime, branch));
        
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.shiftManager = shiftManager;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"date", "shiftTime", "branch"}, ShiftDTO.class);
    }
    public static PK getPK(String date, String shiftTime, String branch) {
        return new PK(getFields(), date, shiftTime, branch);
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
    public long getShiftManager() {
        return shiftManager;
    }
    public void setShiftManager(long shiftManager) {
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
    public Object[] getValues(){
        return new Object[]{this.date, this.shiftTime, this.branch, this.shiftManager};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShiftDTO)) return false;
        ShiftDTO that = (ShiftDTO) o;
        return Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime())) && Object.equals(getBranch(), (that.getBranch())) && Object.equals(getShiftManager(), (that.getShiftManager()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getShiftTime(), getBranch(), getShiftManager());
    }
}
