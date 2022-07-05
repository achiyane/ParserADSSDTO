import DataAccess.DTOs.EmployeeDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Employee;
import java.util.List;


public class EmployeeDAO extends DAO<PK, EmployeeDTO, Employee> {
    public EmployeeDA) {
        super(EmployeeDTO.class, IM.getInstance().getIdentityMap(Employee.class));
        
    }
    @Override
    protected Employee convertDtoToBusiness(EmployeeDTO dto) {
        return new Employe);
    }
    @Override
    protected EmployeeDTO convertBusinessToDto(Employee business) {
        return new EmployeeDT);
    }
    @Override
    protected EmployeeDTO createDTO(List<Object> listFields) {
        return new EmployeeDT);
    }
}
