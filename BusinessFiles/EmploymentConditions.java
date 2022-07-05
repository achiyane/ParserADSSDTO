package Logic;
import DataAccess.DAOs.EmploymentConditionsDAO;
import DataAccess.DTOs.EmploymentConditionsDTO;

public class EmploymentConditions {
    private double salary;
    private int employeeId;
    private String socialBenefits;
    private EmploymentConditionsDAO employmentConditionsDAO;
    public EmploymentConditions(double salary, int employeeId, String socialBenefits) {
        
        this.salary = salary;
        this.employeeId = employeeId;
        this.socialBenefits = socialBenefits;
        this.employmentConditionsDAO = new EmploymentConditionsDAO();
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
        this.employmentConditionsDAO.update(this);
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        this.employmentConditionsDAO.update(this);
    }
    public String getSocialBenefits() {
        return socialBenefits;
    }
    public void setSocialBenefits(String socialBenefits) {
        this.socialBenefits = socialBenefits;
        this.employmentConditionsDAO.update(this);
    }
    @Override
    public String toString() {
        return "EmploymentConditions{salary = [" + this.salary"], " +
        "employeeId = [" + this.employeeId"], " +
        "socialBenefits = [" + this.socialBenefits"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmploymentConditions)) return false;
        EmploymentConditions that = (EmploymentConditions) o;
        return Object.equals(getSalary(), (that.getSalary())) && Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getSocialBenefits(), (that.getSocialBenefits()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getSalary(), getEmployeeId(), getSocialBenefits());
    }
    
}
