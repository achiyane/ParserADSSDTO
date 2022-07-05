import DataAccess.DTOs.EmploymentConditionsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.EmploymentConditions;
import java.util.List;


public class EmploymentConditionsDAO extends DAO<PK, EmploymentConditionsDTO, EmploymentConditions> {
    public EmploymentConditionsDA) {
        super(EmploymentConditionsDTO.class, IM.getInstance().getIdentityMap(EmploymentConditions.class));
        
    }
    @Override
    protected EmploymentConditions convertDtoToBusiness(EmploymentConditionsDTO dto) {
        return new EmploymentCondition);
    }
    @Override
    protected EmploymentConditionsDTO convertBusinessToDto(EmploymentConditions business) {
        return new EmploymentConditionsDT);
    }
    @Override
    protected EmploymentConditionsDTO createDTO(List<Object> listFields) {
        return new EmploymentConditionsDT);
    }
}
