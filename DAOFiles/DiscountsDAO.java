package DataAccess.DAOs;
import DataAccess.DTOs.DiscountsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Discounts;
import java.util.List;

public class DiscountsDAO extends DAO<PK, DiscountsDTO, Discounts> {
    public DiscountsDAO() {
        super(DiscountsDTO.class, IM.getInstance().getIdentityMap(Discounts.class));
    }
    @Override
    protected Discounts convertDtoToBusiness(DiscountsDTO dto) {
        return new Discounts((String) dto.getID(), (int) dto.getCategory_ID(), (int) dto.getProduct_ID(), (double) dto.getDiscount(), (String) dto.getDate_from(), (String) dto.getDate_to());
    }
    @Override
    protected DiscountsDTO convertBusinessToDto(Discounts business) {
        return new DiscountsDTO(business.getID(), business.getCategory_ID(), business.getProduct_ID(), business.getDiscount(), business.getDate_from(), business.getDate_to());
    }
    @Override
    protected DiscountsDTO createDTO(List<Object> listFields) {
        return new DiscountsDTO((String) listFields.get(0), (long) listFields.get(1), (long) listFields.get(2), (double) listFields.get(3), (String) listFields.get(4), (String) listFields.get(5));
    }
}
