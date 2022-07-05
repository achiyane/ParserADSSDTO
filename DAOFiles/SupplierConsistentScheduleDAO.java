package DataAccess.DAOs;
import DataAccess.DTOs.SupplierConsistentScheduleDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierConsistentSchedule;
import java.util.List;

public class SupplierConsistentScheduleDAO extends DAO<PK, SupplierConsistentScheduleDTO, SupplierConsistentSchedule> {
    public SupplierConsistentScheduleDAO() {
        super(SupplierConsistentScheduleDTO.class, IM.getInstance().getIdentityMap(SupplierConsistentSchedule.class));
    }
    @Override
    protected SupplierConsistentSchedule convertDtoToBusiness(SupplierConsistentScheduleDTO dto) {
        return new SupplierConsistentSchedule((String) dto.getCn(), (int) dto.getDay());
    }
    @Override
    protected SupplierConsistentScheduleDTO convertBusinessToDto(SupplierConsistentSchedule business) {
        return new SupplierConsistentScheduleDTO(business.getCn(), business.getDay());
    }
    @Override
    protected SupplierConsistentScheduleDTO createDTO(List<Object> listFields) {
        return new SupplierConsistentScheduleDTO((String) listFields.get(0), (long) listFields.get(1));
    }
}
