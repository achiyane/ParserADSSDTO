import DataAccess.DTOs.AssignmentDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Assignment;
import java.util.List;


public class AssignmentDAO extends DAO<PK, AssignmentDTO, Assignment> {
    public AssignmentDA) {
        super(AssignmentDTO.class, IM.getInstance().getIdentityMap(Assignment.class));
        
    }
    @Override
    protected Assignment convertDtoToBusiness(AssignmentDTO dto) {
        return new Assignmen);
    }
    @Override
    protected AssignmentDTO convertBusinessToDto(Assignment business) {
        return new AssignmentDT);
    }
    @Override
    protected AssignmentDTO createDTO(List<Object> listFields) {
        return new AssignmentDT);
    }
}
