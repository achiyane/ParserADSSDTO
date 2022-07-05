package DataAccess.DAOs;
import DataAccess.DTOs.EmployeeDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Employee;
import java.util.List;

public class EmployeeDAO extends DAO<PK, EmployeeDTO, Employee> {
    public EmployeeDAO() {
        super(EmployeeDTO.class, IM.getInstance().getIdentityMap(Employee.class));
    }
    @Override
    protected Employee convertDtoToBusiness(EmployeeDTO dto) {
        return new Employee((int) dto.getId(), (String) dto.getFirstName(), (String) dto.getLastName(), (String) dto.getPassword(), (String) dto.getStartingDate(), (int) dto.getIsShiftManager(), (String) dto.getJob(), (String) dto.getBranch());
    }
    @Override
    protected EmployeeDTO convertBusinessToDto(Employee business) {
        return new EmployeeDTO(business.getId(), business.getFirstName(), business.getLastName(), business.getPassword(), business.getStartingDate(), business.getIsShiftManager(), business.getJob(), business.getBranch());
    }
    @Override
    protected EmployeeDTO createDTO(List<Object> listFields) {
        return new EmployeeDTO((long) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (String) listFields.get(3), (String) listFields.get(4), (long) listFields.get(5), (String) listFields.get(6), (String) listFields.get(7));
    }
}
