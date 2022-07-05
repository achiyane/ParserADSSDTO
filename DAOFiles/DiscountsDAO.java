import DataAccess.DTOs.DiscountsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Discounts;
import java.util.List;


public class DiscountsDAO extends DAO<PK, DiscountsDTO, Discounts> {
    public DiscountsDA) {
        super(DiscountsDTO.class, IM.getInstance().getIdentityMap(Discounts.class));
        
    }
    @Override
    protected Discounts convertDtoToBusiness(DiscountsDTO dto) {
        return new Discount);
    }
    @Override
    protected DiscountsDTO convertBusinessToDto(Discounts business) {
        return new DiscountsDT);
    }
    @Override
    protected DiscountsDTO createDTO(List<Object> listFields) {
        return new DiscountsDT);
    }
}
