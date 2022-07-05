package Logic;
import DataAccess.DAOs.EmployeeDAO;
import DataAccess.DTOs.EmployeeDTO;

public class Employee {
    private EmployeeDAO employeeDAO;
    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String startingDate;
    private long isShiftManager;
    private String job;
    private String branch;
    
    public Employee(long id, String firstName, String lastName, String password, String startingDate, long isShiftManager, String job, String branch) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.startingDate = startingDate;
        this.isShiftManager = isShiftManager;
        this.job = job;
        this.branch = branch;
        this.employeeDAO = new EmployeeDAO();
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
        this.employeeDAO.update(this);
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.employeeDAO.update(this);
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.employeeDAO.update(this);
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
        this.employeeDAO.update(this);
    }
    public String getStartingDate() {
        return this.startingDate;
    }
    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
        this.employeeDAO.update(this);
    }
    public long getIsShiftManager() {
        return this.isShiftManager;
    }
    public void setIsShiftManager(long isShiftManager) {
        this.isShiftManager = isShiftManager;
        this.employeeDAO.update(this);
    }
    public String getJob() {
        return this.job;
    }
    public void setJob(String job) {
        this.job = job;
        this.employeeDAO.update(this);
    }
    public String getBranch() {
        return this.branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
        this.employeeDAO.update(this);
    }
    @Override
    public String toString(){
        return "Employee{" +
        "id = [" + this.id + "], " +
        "firstName = [" + this.firstName + "], " +
        "lastName = [" + this.lastName + "], " +
        "password = [" + this.password + "], " +
        "startingDate = [" + this.startingDate + "], " +
        "isShiftManager = [" + this.isShiftManager + "], " +
        "job = [" + this.job + "], " +
        "branch = [" + this.branch + "], " +
        "}";
    }
    
}
