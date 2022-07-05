import DataAccess.DTOs.SupplierNotConsistentScheduleDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierNotConsistentSchedule;
import java.util.List;


public class SupplierNotConsistentScheduleDAO extends DAO<PK, SupplierNotConsistentScheduleDTO, SupplierNotConsistentSchedule> {
    public SupplierNotConsistentScheduleDA) {
        super(SupplierNotConsistentScheduleDTO.class, IM.getInstance().getIdentityMap(SupplierNotConsistentSchedule.class));
        
    }
    @Override
    protected SupplierNotConsistentSchedule convertDtoToBusiness(SupplierNotConsistentScheduleDTO dto) {
        return new SupplierNotConsistentSchedul);
    }
    @Override
    protected SupplierNotConsistentScheduleDTO convertBusinessToDto(SupplierNotConsistentSchedule business) {
        return new SupplierNotConsistentScheduleDT);
    }
    @Override
    protected SupplierNotConsistentScheduleDTO createDTO(List<Object> listFields) {
        return new SupplierNotConsistentScheduleDT);
    }
}
