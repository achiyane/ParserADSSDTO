package Logic;
import DataAccess.DAOs.JobsDAO;
import DataAccess.DTOs.JobsDTO;

public class Jobs {
    private String job;
    private JobsDAO jobsDAO;
    public Jobs(String job) {
        
        this.job = job;
        this.jobsDAO = new JobsDAO();
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
        this.jobsDAO.update(this);
    }
    @Override
    public String toString() {
        return "Jobs{job = [" + this.job"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jobs)) return false;
        Jobs that = (Jobs) o;
        return Object.equals(getJob(), (that.getJob()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getJob());
    }
    
}
