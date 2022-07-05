package Logic;
import DataAccess.DAOs.JobsDAO;
import DataAccess.DTOs.JobsDTO;

public class Jobs {
    private JobsDAO jobsDAO;
    private String job;
    
    public Jobs(String job) {
        this.job = job;
        this.jobsDAO = new JobsDAO();
    }
    public String getJob() {
        return this.job;
    }
    public void setJob(String job) {
        this.job = job;
        this.jobsDAO.update(this);
    }
    @Override
    public String toString(){
        return "Jobs{" +
        "job = [" + this.job + "], " +
        "}";
    }
    
}
