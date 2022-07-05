package Service.Objects;

public class SJobs {
    private String job;
    public SJobs(String job) {
        
        this.job = job;
    }
    
    public SJobs(Jobs business) {
        this.job = business.getJob();
    }
    
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    
    @Override
    public String toString() {
        return "Jobs{job = [" + this.job"],  " +
        "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SJobs)) return false;
        SJobs that = (SJobs) o;
        return Object.equals(getJob(), (that.getJob()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getJob());
    }
}
