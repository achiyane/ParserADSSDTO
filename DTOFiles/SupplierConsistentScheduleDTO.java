package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class SupplierConsistentScheduleDTO extends DTO<PK> {
    private String cn;
    private long day;
    
    public SupplierConsistentScheduleDTO(String cn, long day) {
        super(new PK(getFields(), cn, day));
        
        this.cn = cn;
        this.day = day;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"cn", "day"}, SupplierConsistentScheduleDTO.class);
    }
    public static PK getPK(String cn, long day) {
        return new PK(getFields(), cn, day);
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    public long getDay() {
        return day;
    }
    public void setDay(long day) {
        this.day = day;
    }
    @Override
    public String toString() {
        return "SupplierConsistentSchedule{cn = [" + this.cn"], " +
        "day = [" + this.day"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.cn, this.day};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierConsistentScheduleDTO)) return false;
        SupplierConsistentScheduleDTO that = (SupplierConsistentScheduleDTO) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getDay(), (that.getDay()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getDay());
    }
}
