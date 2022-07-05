package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class TransportManagerDTO extends DTO<PK> {
    private long employeeId;
    
    public TransportManagerDTO(long employeeId) {
        super(new PK(getFields(), employeeId));
        
        this.employeeId = employeeId;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"employeeId"}, TransportManagerDTO.class);
    }
    public static PK getPK(long employeeId) {
        return new PK(getFields(), employeeId);
    }
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    @Override
    public String toString() {
        return "TransportManager{employeeId = [" + this.employeeId"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.employeeId};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportManagerDTO)) return false;
        TransportManagerDTO that = (TransportManagerDTO) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId());
    }
}
