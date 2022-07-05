package Logic;
import DataAccess.DAOs.SupplierNotConsistentScheduleDAO;
import DataAccess.DTOs.SupplierNotConsistentScheduleDTO;

public class SupplierNotConsistentSchedule {
    private String cn;
    private int daysTillNextShipment;
    private SupplierNotConsistentScheduleDAO supplierNotConsistentScheduleDAO;
    public SupplierNotConsistentSchedule(String cn, int daysTillNextShipment) {
        
        this.cn = cn;
        this.daysTillNextShipment = daysTillNextShipment;
        this.supplierNotConsistentScheduleDAO = new SupplierNotConsistentScheduleDAO();
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierNotConsistentScheduleDAO.update(this);
    }
    public int getDaysTillNextShipment() {
        return daysTillNextShipment;
    }
    public void setDaysTillNextShipment(int daysTillNextShipment) {
        this.daysTillNextShipment = daysTillNextShipment;
        this.supplierNotConsistentScheduleDAO.update(this);
    }
    @Override
    public String toString() {
        return "SupplierNotConsistentSchedule{cn = [" + this.cn"], " +
        "daysTillNextShipment = [" + this.daysTillNextShipment"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierNotConsistentSchedule)) return false;
        SupplierNotConsistentSchedule that = (SupplierNotConsistentSchedule) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getDaysTillNextShipment(), (that.getDaysTillNextShipment()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getDaysTillNextShipment());
    }
    
}
