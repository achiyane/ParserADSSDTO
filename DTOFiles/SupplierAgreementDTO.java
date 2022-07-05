package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class SupplierAgreementDTO extends DTO<PK> {
    private String cn;
    private String isConsistent;
    
    public SupplierAgreementDTO(String cn, String isConsistent) {
        super(new PK(getFields(), cn));
        
        this.cn = cn;
        this.isConsistent = isConsistent;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"cn"}, SupplierAgreementDTO.class);
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
    public String getIsConsistent() {
        return isConsistent;
    }
    public void setIsConsistent(String isConsistent) {
        this.isConsistent = isConsistent;
    }
    @Override
    public String toString() {
        return "SupplierAgreement{cn = [" + this.cn"], " +
        "isConsistent = [" + this.isConsistent"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.cn, this.isConsistent};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierAgreementDTO)) return false;
        SupplierAgreementDTO that = (SupplierAgreementDTO) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getIsConsistent(), (that.getIsConsistent()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getIsConsistent());
    }
}
