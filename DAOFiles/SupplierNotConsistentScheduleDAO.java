package DataAccess.DAOs;
import DataAccess.DTOs.SupplierNotConsistentScheduleDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierNotConsistentSchedule;
import java.util.List;

public class SupplierNotConsistentScheduleDAO extends DAO<PK, SupplierNotConsistentScheduleDTO, SupplierNotConsistentSchedule> {
    public SupplierNotConsistentScheduleDAO() {
        super(SupplierNotConsistentScheduleDTO.class, IM.getInstance().getIdentityMap(SupplierNotConsistentSchedule.class));
    }
    @Override
    protected SupplierNotConsistentSchedule convertDtoToBusiness(SupplierNotConsistentScheduleDTO dto) {
        return new SupplierNotConsistentSchedule((String) dto.getCn(), (int) dto.getDaysTillNextShipment());
    }
    @Override
    protected SupplierNotConsistentScheduleDTO convertBusinessToDto(SupplierNotConsistentSchedule business) {
        return new SupplierNotConsistentScheduleDTO(business.getCn(), business.getDaysTillNextShipment());
    }
    @Override
    protected SupplierNotConsistentScheduleDTO createDTO(List<Object> listFields) {
        return new SupplierNotConsistentScheduleDTO((String) listFields.get(0), (long) listFields.get(1));
    }
}
