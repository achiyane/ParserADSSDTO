package Service.Objects;

public class STransportManager {
    private int employeeId;
    public STransportManager(int employeeId) {
        
        this.employeeId = employeeId;
    }
    
    public STransportManager(TransportManager business) {
        this.employeeId = business.getEmployeeId();
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    @Override
    public String toString() {
        return "TransportManager{employeeId = [" + this.employeeId"],  " +
        "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof STransportManager)) return false;
        STransportManager that = (STransportManager) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId());
    }
}
