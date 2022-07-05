package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class SupplierNotConsistentScheduleDTO extends DTO<PK> {
    private String cn;
    private long daysTillNextShipment;
    
    public SupplierNotConsistentScheduleDTO(String cn, long daysTillNextShipment) {
        super(new PK(getFields(), cn));
        
        this.cn = cn;
        this.daysTillNextShipment = daysTillNextShipment;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"cn"}, SupplierNotConsistentScheduleDTO.class);
    }
    public static PK getPK(String cn) {
        return new PK(getFields(), cn);
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    public long getDaysTillNextShipment() {
        return daysTillNextShipment;
    }
    public void setDaysTillNextShipment(long daysTillNextShipment) {
        this.daysTillNextShipment = daysTillNextShipment;
    }
    @Override
    public String toString() {
        return "SupplierNotConsistentSchedule{cn = [" + this.cn"], " +
        "daysTillNextShipment = [" + this.daysTillNextShipment"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.cn, this.daysTillNextShipment};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierNotConsistentScheduleDTO)) return false;
        SupplierNotConsistentScheduleDTO that = (SupplierNotConsistentScheduleDTO) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getDaysTillNextShipment(), (that.getDaysTillNextShipment()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getDaysTillNextShipment());
    }
}
