package DataAccess.DAOs;
import DataAccess.DTOs.LocationsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Locations;
import java.util.List;

public class LocationsDAO extends DAO<PK, LocationsDTO, Locations> {
    public LocationsDAO() {
        super(LocationsDTO.class, IM.getInstance().getIdentityMap(Locations.class));
    }
    @Override
    protected Locations convertDtoToBusiness(LocationsDTO dto) {
        return new Locations((int) dto.getItem_ID(), (int) dto.getProduct_ID(), (String) dto.getBranch(), (String) dto.getPlace(), (int) dto.getShelf());
    }
    @Override
    protected LocationsDTO convertBusinessToDto(Locations business) {
        return new LocationsDTO(business.getItem_ID(), business.getProduct_ID(), business.getBranch(), business.getPlace(), business.getShelf());
    }
    @Override
    protected LocationsDTO createDTO(List<Object> listFields) {
        return new LocationsDTO((long) listFields.get(0), (long) listFields.get(1), (String) listFields.get(2), (String) listFields.get(3), (long) listFields.get(4));
    }
}
