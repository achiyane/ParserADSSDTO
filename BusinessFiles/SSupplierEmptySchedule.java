package Logic;
import DataAccess.DAOs.SupplierEmptyScheduleDAO;
import DataAccess.DTOs.SupplierEmptyScheduleDTO;

public class SupplierEmptySchedule {
    private SupplierEmptyScheduleDAO supplieremptyscheduleDAO;
    private String cn;
    
    public SupplierEmptySchedule(String cn) {
        this.cn = cn;
        this.supplieremptyscheduleDAO = new SupplierEmptyScheduleDAO();
    }
    public String getCn() {
        return this.cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplieremptyscheduleDAO.update(this);
    }
    @Override
    public String toString(){
        return "SupplierEmptySchedule{" +
        "cn = [" + this.cn + "], " +
        "}";
    }
    
}
