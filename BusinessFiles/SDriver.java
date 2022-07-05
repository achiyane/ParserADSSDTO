package Logic;
import DataAccess.DAOs.DriverDAO;
import DataAccess.DTOs.DriverDTO;

public class Driver {
    private DriverDAO driverDAO;
    private long employeeId;
    private String license;
    private String lastUpdateDistance;
    private long distance;
    
    public Driver(long employeeId, String license, String lastUpdateDistance, long distance) {
        this.employeeId = employeeId;
        this.license = license;
        this.lastUpdateDistance = lastUpdateDistance;
        this.distance = distance;
        this.driverDAO = new DriverDAO();
    }
    public long getEmployeeId() {
        return this.employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
        this.driverDAO.update(this);
    }
    public String getLicense() {
        return this.license;
    }
    public void setLicense(String license) {
        this.license = license;
        this.driverDAO.update(this);
    }
    public String getLastUpdateDistance() {
        return this.lastUpdateDistance;
    }
    public void setLastUpdateDistance(String lastUpdateDistance) {
        this.lastUpdateDistance = lastUpdateDistance;
        this.driverDAO.update(this);
    }
    public long getDistance() {
        return this.distance;
    }
    public void setDistance(long distance) {
        this.distance = distance;
        this.driverDAO.update(this);
    }
    @Override
    public String toString(){
        return "Driver{" +
        "employeeId = [" + this.employeeId + "], " +
        "license = [" + this.license + "], " +
        "lastUpdateDistance = [" + this.lastUpdateDistance + "], " +
        "distance = [" + this.distance + "], " +
        "}";
    }
    
}
