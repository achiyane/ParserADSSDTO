package Logic;
import DataAccess.DAOs.SupplierConsistentScheduleDAO;
import DataAccess.DTOs.SupplierConsistentScheduleDTO;

public class SupplierConsistentSchedule {
    private String cn;
    private int day;
    private SupplierConsistentScheduleDAO supplierConsistentScheduleDAO;
    public SupplierConsistentSchedule(String cn, int day) {
        
        this.cn = cn;
        this.day = day;
        this.supplierConsistentScheduleDAO = new SupplierConsistentScheduleDAO();
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierConsistentScheduleDAO.update(this);
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
        this.supplierConsistentScheduleDAO.update(this);
    }
    @Override
    public String toString() {
        return "SupplierConsistentSchedule{cn = [" + this.cn"], " +
        "day = [" + this.day"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierConsistentSchedule)) return false;
        SupplierConsistentSchedule that = (SupplierConsistentSchedule) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getDay(), (that.getDay()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getDay());
    }
    
}
