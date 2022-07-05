package Logic;
import DataAccess.DAOs.DriverDAO;
import DataAccess.DTOs.DriverDTO;

public class Driver {
    private int employeeId;
    private String license;
    private String lastUpdateDistance;
    private int distance;
    private DriverDAO driverDAO;
    public Driver(int employeeId, String license, String lastUpdateDistance, int distance) {
        
        this.employeeId = employeeId;
        this.license = license;
        this.lastUpdateDistance = lastUpdateDistance;
        this.distance = distance;
        this.driverDAO = new DriverDAO();
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        this.driverDAO.update(this);
    }
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
        this.driverDAO.update(this);
    }
    public String getLastUpdateDistance() {
        return lastUpdateDistance;
    }
    public void setLastUpdateDistance(String lastUpdateDistance) {
        this.lastUpdateDistance = lastUpdateDistance;
        this.driverDAO.update(this);
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
        this.driverDAO.update(this);
    }
    @Override
    public String toString() {
        return "Driver{employeeId = [" + this.employeeId"], " +
        "license = [" + this.license"], " +
        "lastUpdateDistance = [" + this.lastUpdateDistance"], " +
        "distance = [" + this.distance"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver that = (Driver) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getLicense(), (that.getLicense())) && Object.equals(getLastUpdateDistance(), (that.getLastUpdateDistance())) && Object.equals(getDistance(), (that.getDistance()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getLicense(), getLastUpdateDistance(), getDistance());
    }
    
}
