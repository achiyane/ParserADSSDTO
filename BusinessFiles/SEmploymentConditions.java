package Logic;
import DataAccess.DAOs.EmploymentConditionsDAO;
import DataAccess.DTOs.EmploymentConditionsDTO;

public class EmploymentConditions {
    private EmploymentConditionsDAO employmentconditionsDAO;
    private double salary;
    private long employeeId;
    private String socialBenefits;
    
    public EmploymentConditions(double salary, long employeeId, String socialBenefits) {
        this.salary = salary;
        this.employeeId = employeeId;
        this.socialBenefits = socialBenefits;
        this.employmentconditionsDAO = new EmploymentConditionsDAO();
    }
    public double getSalary() {
        return this.salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
        this.employmentconditionsDAO.update(this);
    }
    public long getEmployeeId() {
        return this.employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
        this.employmentconditionsDAO.update(this);
    }
    public String getSocialBenefits() {
        return this.socialBenefits;
    }
    public void setSocialBenefits(String socialBenefits) {
        this.socialBenefits = socialBenefits;
        this.employmentconditionsDAO.update(this);
    }
    @Override
    public String toString(){
        return "EmploymentConditions{" +
        "salary = [" + this.salary + "], " +
        "employeeId = [" + this.employeeId + "], " +
        "socialBenefits = [" + this.socialBenefits + "], " +
        "}";
    }
    
}
