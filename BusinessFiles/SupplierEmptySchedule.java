package Logic;
import DataAccess.DAOs.SupplierEmptyScheduleDAO;
import DataAccess.DTOs.SupplierEmptyScheduleDTO;

public class SupplierEmptySchedule {
    private String cn;
    private SupplierEmptyScheduleDAO supplierEmptyScheduleDAO;
    public SupplierEmptySchedule(String cn) {
        
        this.cn = cn;
        this.supplierEmptyScheduleDAO = new SupplierEmptyScheduleDAO();
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierEmptyScheduleDAO.update(this);
    }
    @Override
    public String toString() {
        return "SupplierEmptySchedule{cn = [" + this.cn"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierEmptySchedule)) return false;
        SupplierEmptySchedule that = (SupplierEmptySchedule) o;
        return Object.equals(getCn(), (that.getCn()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getCn());
    }
    
}
