package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class EmploymentConditionsDTO extends DTO<PK> {
    private double salary;
    private long employeeId;
    private String socialBenefits;
    
    public EmploymentConditionsDTO(double salary, long employeeId, String socialBenefits) {
        super(new PK(getFields(), employeeId));
        
        this.salary = salary;
        this.employeeId = employeeId;
        this.socialBenefits = socialBenefits;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"employeeId"}, EmploymentConditionsDTO.class);
    }
    public static PK getPK(long employeeId) {
        return new PK(getFields(), employeeId);
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public String getSocialBenefits() {
        return socialBenefits;
    }
    public void setSocialBenefits(String socialBenefits) {
        this.socialBenefits = socialBenefits;
    }
    @Override
    public String toString() {
        return "EmploymentConditions{salary = [" + this.salary"], " +
        "employeeId = [" + this.employeeId"], " +
        "socialBenefits = [" + this.socialBenefits"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.salary, this.employeeId, this.socialBenefits};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmploymentConditionsDTO)) return false;
        EmploymentConditionsDTO that = (EmploymentConditionsDTO) o;
        return Object.equals(getSalary(), (that.getSalary())) && Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getSocialBenefits(), (that.getSocialBenefits()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getSalary(), getEmployeeId(), getSocialBenefits());
    }
}
