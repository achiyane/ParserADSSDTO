package DataAccess.DAOs;
import DataAccess.DTOs.JobsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Jobs;
import java.util.List;

public class JobsDAO extends DAO<PK, JobsDTO, Jobs> {
    public JobsDAO() {
        super(JobsDTO.class, IM.getInstance().getIdentityMap(Jobs.class));
    }
    @Override
    protected Jobs convertDtoToBusiness(JobsDTO dto) {
        return new Jobs((String) dto.getJob());
    }
    @Override
    protected JobsDTO convertBusinessToDto(Jobs business) {
        return new JobsDTO(business.getJob());
    }
    @Override
    protected JobsDTO createDTO(List<Object> listFields) {
        return new JobsDTO((String) listFields.get(0));
    }
}
