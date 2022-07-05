package DataAccess.DAOs;
import DataAccess.DTOs.ShiftDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Shift;
import java.util.List;

public class ShiftDAO extends DAO<PK, ShiftDTO, Shift> {
    public ShiftDAO() {
        super(ShiftDTO.class, IM.getInstance().getIdentityMap(Shift.class));
    }
    @Override
    protected Shift convertDtoToBusiness(ShiftDTO dto) {
        return new Shift((String) dto.getDate(), (String) dto.getShiftTime(), (String) dto.getBranch(), (int) dto.getShiftManager());
    }
    @Override
    protected ShiftDTO convertBusinessToDto(Shift business) {
        return new ShiftDTO(business.getDate(), business.getShiftTime(), business.getBranch(), business.getShiftManager());
    }
    @Override
    protected ShiftDTO createDTO(List<Object> listFields) {
        return new ShiftDTO((String) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (long) listFields.get(3));
    }
}
