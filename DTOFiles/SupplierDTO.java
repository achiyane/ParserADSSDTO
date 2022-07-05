package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class SupplierDTO extends DTO<PK> {
    private String cn;
    
    public SupplierDTO(String cn) {
        super(new PK(getFields(), cn));
        
        this.cn = cn;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"cn"}, SupplierDTO.class);
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
        return "Supplier{cn = [" + this.cn"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.cn};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierDTO)) return false;
        SupplierDTO that = (SupplierDTO) o;
        return Object.equals(getCn(), (that.getCn()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn());
    }
}
