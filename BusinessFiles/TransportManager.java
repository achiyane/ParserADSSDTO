package Logic;
import DataAccess.DAOs.TransportManagerDAO;
import DataAccess.DTOs.TransportManagerDTO;

public class TransportManager {
    private int employeeId;
    private TransportManagerDAO transportManagerDAO;
    public TransportManager(int employeeId) {
        
        this.employeeId = employeeId;
        this.transportManagerDAO = new TransportManagerDAO();
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        this.transportManagerDAO.update(this);
    }
    @Override
    public String toString() {
        return "TransportManager{employeeId = [" + this.employeeId"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportManager)) return false;
        TransportManager that = (TransportManager) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId());
    }
    
}
