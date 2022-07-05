package Service.Objects;

public class SAssignment {
    private String date;
    private String shiftTime;
    private String branch;
    private String job;
    private int capacity;
    private int quantity;
    public SAssignment(String date, String shiftTime, String branch, String job, int capacity, int quantity) {
        
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.job = job;
        this.capacity = capacity;
        this.quantity = quantity;
    }
    
    public SAssignment(Assignment business) {
        this.date = business.getDate();
        this.shiftTime = business.getShiftTime();
        this.branch = business.getBranch();
        this.job = business.getJob();
        this.capacity = business.getCapacity();
        this.quantity = business.getQuantity();
    }
    
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getShiftTime() {
        return shiftTime;
    }
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "Assignment{date = [" + this.date"], " +
        "shiftTime = [" + this.shiftTime"], " +
        "branch = [" + this.branch"], " +
        "job = [" + this.job"], " +
        "capacity = [" + this.capacity"], " +
        "quantity = [" + this.quantity"],  " +
        "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SAssignment)) return false;
        SAssignment that = (SAssignment) o;
        return Object.equals(getDate(), (that.getDate())) && Object.equals(getShiftTime(), (that.getShiftTime())) && Object.equals(getBranch(), (that.getBranch())) && Object.equals(getJob(), (that.getJob())) && Object.equals(getCapacity(), (that.getCapacity())) && Object.equals(getQuantity(), (that.getQuantity()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getShiftTime(), getBranch(), getJob(), getCapacity(), getQuantity());
    }
}
