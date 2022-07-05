package DataAccess.DAOs;
import DataAccess.DTOs.SupplierCardDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierCard;
import java.util.List;

public class SupplierCardDAO extends DAO<PK, SupplierCardDTO, SupplierCard> {
    public SupplierCardDAO() {
        super(SupplierCardDTO.class, IM.getInstance().getIdentityMap(SupplierCard.class));
    }
    @Override
    protected SupplierCard convertDtoToBusiness(SupplierCardDTO dto) {
        return new SupplierCard((String) dto.getCn(), (String) dto.getSupplierName(), (String) dto.getBankAccountNum(), (String) dto.getPaymentMethod(), (String) dto.getPaymentFrequency(), (String) dto.getAddress());
    }
    @Override
    protected SupplierCardDTO convertBusinessToDto(SupplierCard business) {
        return new SupplierCardDTO(business.getCn(), business.getSupplierName(), business.getBankAccountNum(), business.getPaymentMethod(), business.getPaymentFrequency(), business.getAddress());
    }
    @Override
    protected SupplierCardDTO createDTO(List<Object> listFields) {
        return new SupplierCardDTO((String) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (String) listFields.get(3), (String) listFields.get(4), (String) listFields.get(5));
    }
}
