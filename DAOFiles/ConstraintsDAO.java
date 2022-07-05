package DataAccess.DAOs;
import DataAccess.DTOs.ConstraintsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Constraints;
import java.util.List;

public class ConstraintsDAO extends DAO<PK, ConstraintsDTO, Constraints> {
    public ConstraintsDAO() {
        super(ConstraintsDTO.class, IM.getInstance().getIdentityMap(Constraints.class));
    }
    @Override
    protected Constraints convertDtoToBusiness(ConstraintsDTO dto) {
        return new Constraints((int) dto.getEmployeeId(), (String) dto.getDate(), (String) dto.getShiftTime());
    }
    @Override
    protected ConstraintsDTO convertBusinessToDto(Constraints business) {
        return new ConstraintsDTO(business.getEmployeeId(), business.getDate(), business.getShiftTime());
    }
    @Override
    protected ConstraintsDTO createDTO(List<Object> listFields) {
        return new ConstraintsDTO((long) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2));
    }
}
