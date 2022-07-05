package DataAccess.DAOs;
import DataAccess.DTOs.SupplierEmptyScheduleDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierEmptySchedule;
import java.util.List;

public class SupplierEmptyScheduleDAO extends DAO<PK, SupplierEmptyScheduleDTO, SupplierEmptySchedule> {
    public SupplierEmptyScheduleDAO() {
        super(SupplierEmptyScheduleDTO.class, IM.getInstance().getIdentityMap(SupplierEmptySchedule.class));
    }
    @Override
    protected SupplierEmptySchedule convertDtoToBusiness(SupplierEmptyScheduleDTO dto) {
        return new SupplierEmptySchedule((String) dto.getCn());
    }
    @Override
    protected SupplierEmptyScheduleDTO convertBusinessToDto(SupplierEmptySchedule business) {
        return new SupplierEmptyScheduleDTO(business.getCn());
    }
    @Override
    protected SupplierEmptyScheduleDTO createDTO(List<Object> listFields) {
        return new SupplierEmptyScheduleDTO((String) listFields.get(0));
    }
}
