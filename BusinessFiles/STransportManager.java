package Logic;
import DataAccess.DAOs.TransportManagerDAO;
import DataAccess.DTOs.TransportManagerDTO;

public class TransportManager {
    private TransportManagerDAO transportmanagerDAO;
    private long employeeId;
    
    public TransportManager(long employeeId) {
        this.employeeId = employeeId;
        this.transportmanagerDAO = new TransportManagerDAO();
    }
    public long getEmployeeId() {
        return this.employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
        this.transportmanagerDAO.update(this);
    }
    @Override
    public String toString(){
        return "TransportManager{" +
        "employeeId = [" + this.employeeId + "], " +
        "}";
    }
    
}
