import DataAccess.DTOs.ItemsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Items;
import java.util.List;
import DataAccess.DAOs.LocationsDAO;


public class ItemsDAO extends DAO<PK, ItemsDTO, Items> {
    private LocationsDAO LocationsDAO;
    public ItemsDA) {
        super(ItemsDTO.class, IM.getInstance().getIdentityMap(Items.class));
        
        this.LocationsDAO = new LocationsDAO();
    }
    @Override
    protected Items convertDtoToBusiness(ItemsDTO dto) {
        return new Items((LocationsDAO) dto.getLocationsDAO());
    }
    @Override
    protected ItemsDTO convertBusinessToDto(Items business) {
        return new ItemsDTO(business.getLocationsDAO());
    }
    @Override
    protected ItemsDTO createDTO(List<Object> listFields) {
        return new ItemsDTO((LocationsDAO) listFields.get(0));
    }
    public List<Locations> getAllLocationss(int ID){
        return LocationsDAO.selectAllUnderConditionToBusiness("item_ID = " + ID);
        
    }
}
