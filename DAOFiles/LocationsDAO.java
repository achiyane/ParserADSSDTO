import DataAccess.DTOs.LocationsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Locations;
import java.util.List;


public class LocationsDAO extends DAO<PK, LocationsDTO, Locations> {
    public LocationsDA) {
        super(LocationsDTO.class, IM.getInstance().getIdentityMap(Locations.class));
        
    }
    @Override
    protected Locations convertDtoToBusiness(LocationsDTO dto) {
        return new Location);
    }
    @Override
    protected LocationsDTO convertBusinessToDto(Locations business) {
        return new LocationsDT);
    }
    @Override
    protected LocationsDTO createDTO(List<Object> listFields) {
        return new LocationsDT);
    }
}
