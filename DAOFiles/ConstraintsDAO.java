import DataAccess.DTOs.ConstraintsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Constraints;
import java.util.List;


public class ConstraintsDAO extends DAO<PK, ConstraintsDTO, Constraints> {
    public ConstraintsDA) {
        super(ConstraintsDTO.class, IM.getInstance().getIdentityMap(Constraints.class));
        
    }
    @Override
    protected Constraints convertDtoToBusiness(ConstraintsDTO dto) {
        return new Constraint);
    }
    @Override
    protected ConstraintsDTO convertBusinessToDto(Constraints business) {
        return new ConstraintsDT);
    }
    @Override
    protected ConstraintsDTO createDTO(List<Object> listFields) {
        return new ConstraintsDT);
    }
}
