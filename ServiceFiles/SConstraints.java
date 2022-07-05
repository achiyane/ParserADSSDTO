package Service.Objects;

public class SConstraints {
    private int employeeId;
    private String date;
    private String shiftTime;
    public SConstraints(int employeeId, String date, String shiftTime) {
        
        this.employeeId = employeeId;
        this.date = date;
        this.shiftTime = shiftTime;
    }
    
    public SConstraints(Constraints business) {
        this.employeeId = business.getEmployeeId();
        this.date = business.getDate();
        this.shiftTime = business.getShiftTime();
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SConstraints)) return false;
        SConstraints that = (SConstraints) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getDate(), getShiftTime());
    }
}
