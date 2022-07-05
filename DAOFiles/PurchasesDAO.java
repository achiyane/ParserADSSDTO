package DataAccess.DAOs;
import DataAccess.DTOs.PurchasesDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Purchases;
import java.util.List;

public class PurchasesDAO extends DAO<PK, PurchasesDTO, Purchases> {
    public PurchasesDAO() {
        super(PurchasesDTO.class, IM.getInstance().getIdentityMap(Purchases.class));
    }
    @Override
    protected Purchases convertDtoToBusiness(PurchasesDTO dto) {
        return new Purchases((int) dto.getProduct_ID(), (double) dto.getCost_price(), (double) dto.getSale_price(), (double) dto.getDiscount(), (int) dto.getQuantity(), (String) dto.getSupplier(), (String) dto.getPurchase_time());
    }
    @Override
    protected PurchasesDTO convertBusinessToDto(Purchases business) {
        return new PurchasesDTO(business.getProduct_ID(), business.getCost_price(), business.getSale_price(), business.getDiscount(), business.getQuantity(), business.getSupplier(), business.getPurchase_time());
    }
    @Override
    protected PurchasesDTO createDTO(List<Object> listFields) {
        return new PurchasesDTO((long) listFields.get(0), (double) listFields.get(1), (double) listFields.get(2), (double) listFields.get(3), (long) listFields.get(4), (String) listFields.get(5), (String) listFields.get(6));
    }
}
