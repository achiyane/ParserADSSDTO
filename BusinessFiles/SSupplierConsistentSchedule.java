package Logic;
import DataAccess.DAOs.SupplierConsistentScheduleDAO;
import DataAccess.DTOs.SupplierConsistentScheduleDTO;

public class SupplierConsistentSchedule {
    private SupplierConsistentScheduleDAO supplierconsistentscheduleDAO;
    private String cn;
    private long day;
    
    public SupplierConsistentSchedule(String cn, long day) {
        this.cn = cn;
        this.day = day;
        this.supplierconsistentscheduleDAO = new SupplierConsistentScheduleDAO();
    }
    public String getCn() {
        return this.cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierconsistentscheduleDAO.update(this);
    }
    public long getDay() {
        return this.day;
    }
    public void setDay(long day) {
        this.day = day;
        this.supplierconsistentscheduleDAO.update(this);
    }
    @Override
    public String toString(){
        return "SupplierConsistentSchedule{" +
        "cn = [" + this.cn + "], " +
        "day = [" + this.day + "], " +
        "}";
    }
    
}
