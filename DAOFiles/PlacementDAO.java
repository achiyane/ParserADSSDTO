package DataAccess.DAOs;
import DataAccess.DTOs.PlacementDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Placement;
import java.util.List;

public class PlacementDAO extends DAO<PK, PlacementDTO, Placement> {
    public PlacementDAO() {
        super(PlacementDTO.class, IM.getInstance().getIdentityMap(Placement.class));
    }
    @Override
    protected Placement convertDtoToBusiness(PlacementDTO dto) {
        return new Placement((String) dto.getDate(), (String) dto.getShiftTime(), (String) dto.getBranch(), (int) dto.getEmployeeId(), (String) dto.getJob());
    }
    @Override
    protected PlacementDTO convertBusinessToDto(Placement business) {
        return new PlacementDTO(business.getDate(), business.getShiftTime(), business.getBranch(), business.getEmployeeId(), business.getJob());
    }
    @Override
    protected PlacementDTO createDTO(List<Object> listFields) {
        return new PlacementDTO((String) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (long) listFields.get(3), (String) listFields.get(4));
    }
}
