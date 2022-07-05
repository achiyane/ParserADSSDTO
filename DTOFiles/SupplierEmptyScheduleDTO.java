package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class SupplierEmptyScheduleDTO extends DTO<PK> {
    private String cn;
    
    public SupplierEmptyScheduleDTO(String cn) {
        super(new PK(getFields(), cn));
        
        this.cn = cn;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"cn"}, SupplierEmptyScheduleDTO.class);
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
    @Override
    public String toString() {
        return "SupplierEmptySchedule{cn = [" + this.cn"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.cn};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierEmptyScheduleDTO)) return false;
        SupplierEmptyScheduleDTO that = (SupplierEmptyScheduleDTO) o;
        return Object.equals(getCn(), (that.getCn()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn());
    }
}
