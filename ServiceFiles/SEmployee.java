package Service.Objects;

public class SEmployee {
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String startingDate;
    private int isShiftManager;
    private String job;
    private String branch;
    public SEmployee(int id, String firstName, String lastName, String password, String startingDate, int isShiftManager, String job, String branch) {
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.startingDate = startingDate;
        this.isShiftManager = isShiftManager;
        this.job = job;
        this.branch = branch;
    }
    
    public SEmployee(Employee business) {
        this.id = business.getId();
        this.firstName = business.getFirstName();
        this.lastName = business.getLastName();
        this.password = business.getPassword();
        this.startingDate = business.getStartingDate();
        this.isShiftManager = business.getIsShiftManager();
        this.job = business.getJob();
        this.branch = business.getBranch();
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getStartingDate() {
        return startingDate;
    }
    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }
    public int getIsShiftManager() {
        return isShiftManager;
    }
    public void setIsShiftManager(int isShiftManager) {
        this.isShiftManager = isShiftManager;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    @Override
    public String toString() {
        return "Employee{id = [" + this.id"], " +
        "firstName = [" + this.firstName"], " +
        "lastName = [" + this.lastName"], " +
        "password = [" + this.password"], " +
        "startingDate = [" + this.startingDate"], " +
        "isShiftManager = [" + this.isShiftManager"], " +
        "job = [" + this.job"], " +
        "branch = [" + this.branch"],  " +
        "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SEmployee)) return false;
        SEmployee that = (SEmployee) o;
        return Object.equals(getId(), (that.getId())) && Object.equals(getFirstName(), (that.getFirstName())) && Object.equals(getLastName(), (that.getLastName())) && Object.equals(getPassword(), (that.getPassword())) && Object.equals(getStartingDate(), (that.getStartingDate())) && Object.equals(getIsShiftManager(), (that.getIsShiftManager())) && Object.equals(getJob(), (that.getJob())) && Object.equals(getBranch(), (that.getBranch()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getPassword(), getStartingDate(), getIsShiftManager(), getJob(), getBranch());
    }
}
