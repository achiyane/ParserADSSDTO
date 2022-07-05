import DataAccess.DTOs.SupplierConsistentScheduleDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierConsistentSchedule;
import java.util.List;


public class SupplierConsistentScheduleDAO extends DAO<PK, SupplierConsistentScheduleDTO, SupplierConsistentSchedule> {
    public SupplierConsistentScheduleDA) {
        super(SupplierConsistentScheduleDTO.class, IM.getInstance().getIdentityMap(SupplierConsistentSchedule.class));
        
    }
    @Override
    protected SupplierConsistentSchedule convertDtoToBusiness(SupplierConsistentScheduleDTO dto) {
        return new SupplierConsistentSchedul);
    }
    @Override
    protected SupplierConsistentScheduleDTO convertBusinessToDto(SupplierConsistentSchedule business) {
        return new SupplierConsistentScheduleDT);
    }
    @Override
    protected SupplierConsistentScheduleDTO createDTO(List<Object> listFields) {
        return new SupplierConsistentScheduleDT);
    }
}
