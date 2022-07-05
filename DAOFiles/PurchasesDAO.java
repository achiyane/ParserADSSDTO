import DataAccess.DTOs.PurchasesDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Purchases;
import java.util.List;


public class PurchasesDAO extends DAO<PK, PurchasesDTO, Purchases> {
    public PurchasesDA) {
        super(PurchasesDTO.class, IM.getInstance().getIdentityMap(Purchases.class));
        
    }
    @Override
    protected Purchases convertDtoToBusiness(PurchasesDTO dto) {
        return new Purchase);
    }
    @Override
    protected PurchasesDTO convertBusinessToDto(Purchases business) {
        return new PurchasesDT);
    }
    @Override
    protected PurchasesDTO createDTO(List<Object> listFields) {
        return new PurchasesDT);
    }
}
