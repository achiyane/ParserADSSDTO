import DataAccess.DTOs.JobsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Jobs;
import java.util.List;


public class JobsDAO extends DAO<PK, JobsDTO, Jobs> {
    public JobsDA) {
        super(JobsDTO.class, IM.getInstance().getIdentityMap(Jobs.class));
        
    }
    @Override
    protected Jobs convertDtoToBusiness(JobsDTO dto) {
        return new Job);
    }
    @Override
    protected JobsDTO convertBusinessToDto(Jobs business) {
        return new JobsDT);
    }
    @Override
    protected JobsDTO createDTO(List<Object> listFields) {
        return new JobsDT);
    }
}
