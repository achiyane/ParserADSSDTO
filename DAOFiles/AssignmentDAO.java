package DataAccess.DAOs;
import DataAccess.DTOs.AssignmentDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Assignment;
import java.util.List;

public class AssignmentDAO extends DAO<PK, AssignmentDTO, Assignment> {
    public AssignmentDAO() {
        super(AssignmentDTO.class, IM.getInstance().getIdentityMap(Assignment.class));
    }
    @Override
    protected Assignment convertDtoToBusiness(AssignmentDTO dto) {
        return new Assignment((String) dto.getDate(), (String) dto.getShiftTime(), (String) dto.getBranch(), (String) dto.getJob(), (int) dto.getCapacity(), (int) dto.getQuantity());
    }
    @Override
    protected AssignmentDTO convertBusinessToDto(Assignment business) {
        return new AssignmentDTO(business.getDate(), business.getShiftTime(), business.getBranch(), business.getJob(), business.getCapacity(), business.getQuantity());
    }
    @Override
    protected AssignmentDTO createDTO(List<Object> listFields) {
        return new AssignmentDTO((String) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (String) listFields.get(3), (long) listFields.get(4), (long) listFields.get(5));
    }
}
