package Logic;
import DataAccess.DAOs.SupplierNotConsistentScheduleDAO;
import DataAccess.DTOs.SupplierNotConsistentScheduleDTO;

public class SupplierNotConsistentSchedule {
    private SupplierNotConsistentScheduleDAO suppliernotconsistentscheduleDAO;
    private String cn;
    private long daysTillNextShipment;
    
    public SupplierNotConsistentSchedule(String cn, long daysTillNextShipment) {
        this.cn = cn;
        this.daysTillNextShipment = daysTillNextShipment;
        this.suppliernotconsistentscheduleDAO = new SupplierNotConsistentScheduleDAO();
    }
    public String getCn() {
        return this.cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.suppliernotconsistentscheduleDAO.update(this);
    }
    public long getDaysTillNextShipment() {
        return this.daysTillNextShipment;
    }
    public void setDaysTillNextShipment(long daysTillNextShipment) {
        this.daysTillNextShipment = daysTillNextShipment;
        this.suppliernotconsistentscheduleDAO.update(this);
    }
    @Override
    public String toString(){
        return "SupplierNotConsistentSchedule{" +
        "cn = [" + this.cn + "], " +
        "daysTillNextShipment = [" + this.daysTillNextShipment + "], " +
        "}";
    }
    
}
