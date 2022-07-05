import DataAccess.DTOs.ShiftDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Shift;
import java.util.List;


public class ShiftDAO extends DAO<PK, ShiftDTO, Shift> {
    public ShiftDA) {
        super(ShiftDTO.class, IM.getInstance().getIdentityMap(Shift.class));
        
    }
    @Override
    protected Shift convertDtoToBusiness(ShiftDTO dto) {
        return new Shif);
    }
    @Override
    protected ShiftDTO convertBusinessToDto(Shift business) {
        return new ShiftDT);
    }
    @Override
    protected ShiftDTO createDTO(List<Object> listFields) {
        return new ShiftDT);
    }
}
