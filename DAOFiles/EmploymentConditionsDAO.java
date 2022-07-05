package DataAccess.DAOs;
import DataAccess.DTOs.EmploymentConditionsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.EmploymentConditions;
import java.util.List;

public class EmploymentConditionsDAO extends DAO<PK, EmploymentConditionsDTO, EmploymentConditions> {
    public EmploymentConditionsDAO() {
        super(EmploymentConditionsDTO.class, IM.getInstance().getIdentityMap(EmploymentConditions.class));
    }
    @Override
    protected EmploymentConditions convertDtoToBusiness(EmploymentConditionsDTO dto) {
        return new EmploymentConditions((double) dto.getSalary(), (int) dto.getEmployeeId(), (String) dto.getSocialBenefits());
    }
    @Override
    protected EmploymentConditionsDTO convertBusinessToDto(EmploymentConditions business) {
        return new EmploymentConditionsDTO(business.getSalary(), business.getEmployeeId(), business.getSocialBenefits());
    }
    @Override
    protected EmploymentConditionsDTO createDTO(List<Object> listFields) {
        return new EmploymentConditionsDTO((double) listFields.get(0), (long) listFields.get(1), (String) listFields.get(2));
    }
}
