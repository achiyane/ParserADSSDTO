package DataAccess.DAOs;
import DataAccess.DTOs.ItemsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Items;
import java.util.List;

public class ItemsDAO extends DAO<PK, ItemsDTO, Items> {
    public ItemsDAO() {
        super(ItemsDTO.class, IM.getInstance().getIdentityMap(Items.class));
    }
    @Override
    protected Items convertDtoToBusiness(ItemsDTO dto) {
        return new Items((int) dto.getID(), (int) dto.getProduct_ID(), (String) dto.getIs_flaw(), (String) dto.getExpired());
    }
    @Override
    protected ItemsDTO convertBusinessToDto(Items business) {
        return new ItemsDTO(business.getID(), business.getProduct_ID(), business.getIs_flaw(), business.getExpired());
    }
    @Override
    protected ItemsDTO createDTO(List<Object> listFields) {
        return new ItemsDTO((long) listFields.get(0), (long) listFields.get(1), (String) listFields.get(2), (String) listFields.get(3));
    }
}
