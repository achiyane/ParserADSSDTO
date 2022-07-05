package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class ConstraintsDTO extends DTO<PK> {
    private long employeeId;
    private String date;
    private String shiftTime;
    
    public ConstraintsDTO(long employeeId, String date, String shiftTime) {
        super(new PK(getFields(), employeeId, date, shiftTime));
        
        this.employeeId = employeeId;
        this.date = date;
        this.shiftTime = shiftTime;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"employeeId", "date", "shiftTime"}, ConstraintsDTO.class);
    }
    public static PK getPK(long employeeId, String date, String shiftTime) {
        return new PK(getFields(), employeeId, date, shiftTime);
    }
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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
    @Override
    public String toString() {
        return "Constraints{employeeId = [" + this.employeeId"], " +
        "date = [" + this.date"], " +
        "shiftTime = [" + this.shiftTime"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.employeeId, this.date, this.shiftTime};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConstraintsDTO)) return false;
        ConstraintsDTO that = (ConstraintsDTO) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getDate(), getShiftTime());
    }
}
