import DataAccess.DTOs.SupplierCardDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierCard;
import java.util.List;


public class SupplierCardDAO extends DAO<PK, SupplierCardDTO, SupplierCard> {
    public SupplierCardDA) {
        super(SupplierCardDTO.class, IM.getInstance().getIdentityMap(SupplierCard.class));
        
    }
    @Override
    protected SupplierCard convertDtoToBusiness(SupplierCardDTO dto) {
        return new SupplierCar);
    }
    @Override
    protected SupplierCardDTO convertBusinessToDto(SupplierCard business) {
        return new SupplierCardDT);
    }
    @Override
    protected SupplierCardDTO createDTO(List<Object> listFields) {
        return new SupplierCardDT);
    }
}
