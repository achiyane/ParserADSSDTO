package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class DriverDTO extends DTO<PK> {
    private long employeeId;
    private String license;
    private String lastUpdateDistance;
    private long distance;
    
    public DriverDTO(long employeeId, String license, String lastUpdateDistance, long distance) {
        super(new PK(getFields(), employeeId));
        
        this.employeeId = employeeId;
        this.license = license;
        this.lastUpdateDistance = lastUpdateDistance;
        this.distance = distance;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"employeeId"}, DriverDTO.class);
    }
    public static PK getPK(long employeeId) {
        return new PK(getFields(), employeeId);
    }
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
    public String getLastUpdateDistance() {
        return lastUpdateDistance;
    }
    public void setLastUpdateDistance(String lastUpdateDistance) {
        this.lastUpdateDistance = lastUpdateDistance;
    }
    public long getDistance() {
        return distance;
    }
    public void setDistance(long distance) {
        this.distance = distance;
    }
    @Override
    public String toString() {
        return "Driver{employeeId = [" + this.employeeId"], " +
        "license = [" + this.license"], " +
        "lastUpdateDistance = [" + this.lastUpdateDistance"], " +
        "distance = [" + this.distance"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.employeeId, this.license, this.lastUpdateDistance, this.distance};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriverDTO)) return false;
        DriverDTO that = (DriverDTO) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getLicense(), (that.getLicense())) && Object.equals(getLastUpdateDistance(), (that.getLastUpdateDistance())) && Object.equals(getDistance(), (that.getDistance()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getLicense(), getLastUpdateDistance(), getDistance());
    }
}
