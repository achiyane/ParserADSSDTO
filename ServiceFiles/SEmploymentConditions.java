package Service.Objects;

public class SEmploymentConditions {
    private double salary;
    private int employeeId;
    private String socialBenefits;
    public SEmploymentConditions(double salary, int employeeId, String socialBenefits) {
        
        this.salary = salary;
        this.employeeId = employeeId;
        this.socialBenefits = socialBenefits;
    }
    
    public SEmploymentConditions(EmploymentConditions business) {
        this.salary = business.getSalary();
        this.employeeId = business.getEmployeeId();
        this.socialBenefits = business.getSocialBenefits();
    }
    
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SEmploymentConditions)) return false;
        SEmploymentConditions that = (SEmploymentConditions) o;
        return Object.equals(getSalary(), (that.getSalary())) && Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getSocialBenefits(), (that.getSocialBenefits()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getSalary(), getEmployeeId(), getSocialBenefits());
    }
}
