package Service.Objects;

public class SDriver {
    private int employeeId;
    private String license;
    private String lastUpdateDistance;
    private int distance;
    public SDriver(int employeeId, String license, String lastUpdateDistance, int distance) {
        
        this.employeeId = employeeId;
        this.license = license;
        this.lastUpdateDistance = lastUpdateDistance;
        this.distance = distance;
    }
    
    public SDriver(Driver business) {
        this.employeeId = business.getEmployeeId();
        this.license = business.getLicense();
        this.lastUpdateDistance = business.getLastUpdateDistance();
        this.distance = business.getDistance();
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
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
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SDriver)) return false;
        SDriver that = (SDriver) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getLicense(), (that.getLicense())) && Object.equals(getLastUpdateDistance(), (that.getLastUpdateDistance())) && Object.equals(getDistance(), (that.getDistance()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getLicense(), getLastUpdateDistance(), getDistance());
    }
}
