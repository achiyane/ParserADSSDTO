import DataAccess.DTOs.SupplierEmptyScheduleDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierEmptySchedule;
import java.util.List;


public class SupplierEmptyScheduleDAO extends DAO<PK, SupplierEmptyScheduleDTO, SupplierEmptySchedule> {
    public SupplierEmptyScheduleDA) {
        super(SupplierEmptyScheduleDTO.class, IM.getInstance().getIdentityMap(SupplierEmptySchedule.class));
        
    }
    @Override
    protected SupplierEmptySchedule convertDtoToBusiness(SupplierEmptyScheduleDTO dto) {
        return new SupplierEmptySchedul);
    }
    @Override
    protected SupplierEmptyScheduleDTO convertBusinessToDto(SupplierEmptySchedule business) {
        return new SupplierEmptyScheduleDT);
    }
    @Override
    protected SupplierEmptyScheduleDTO createDTO(List<Object> listFields) {
        return new SupplierEmptyScheduleDT);
    }
}
