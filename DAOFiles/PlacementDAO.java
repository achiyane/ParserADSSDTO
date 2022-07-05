import DataAccess.DTOs.PlacementDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Placement;
import java.util.List;


public class PlacementDAO extends DAO<PK, PlacementDTO, Placement> {
    public PlacementDA) {
        super(PlacementDTO.class, IM.getInstance().getIdentityMap(Placement.class));
        
    }
    @Override
    protected Placement convertDtoToBusiness(PlacementDTO dto) {
        return new Placemen);
    }
    @Override
    protected PlacementDTO convertBusinessToDto(Placement business) {
        return new PlacementDT);
    }
    @Override
    protected PlacementDTO createDTO(List<Object> listFields) {
        return new PlacementDT);
    }
}
