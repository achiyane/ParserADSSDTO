package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class JobsDTO extends DTO<PK> {
    private String job;
    
    public JobsDTO(String job) {
        super(new PK(getFields(), job));
        
        this.job = job;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"job"}, JobsDTO.class);
    }
    public static PK getPK(String job) {
        return new PK(getFields(), job);
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
    public Object[] getValues(){
        return new Object[]{this.job};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobsDTO)) return false;
        JobsDTO that = (JobsDTO) o;
        return Object.equals(getJob(), (that.getJob()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getJob());
    }
}
