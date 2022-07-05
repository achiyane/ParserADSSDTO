package DataAccess.DAOs;
import DataAccess.DTOs.BillOfQuantitiyDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.BillOfQuantitiy;
import java.util.List;

public class BillOfQuantitiyDAO extends DAO<PK, BillOfQuantitiyDTO, BillOfQuantitiy> {
    public BillOfQuantitiyDAO() {
        super(BillOfQuantitiyDTO.class, IM.getInstance().getIdentityMap(BillOfQuantitiy.class));
    }
    @Override
    protected BillOfQuantitiy convertDtoToBusiness(BillOfQuantitiyDTO dto) {
        return new BillOfQuantitiy((String) dto.getCn(), (String) dto.getProductName(), (double) dto.getDiscount(), (int) dto.getStartRange());
    }
    @Override
    protected BillOfQuantitiyDTO convertBusinessToDto(BillOfQuantitiy business) {
        return new BillOfQuantitiyDTO(business.getCn(), business.getProductName(), business.getDiscount(), business.getStartRange());
    }
    @Override
    protected BillOfQuantitiyDTO createDTO(List<Object> listFields) {
        return new BillOfQuantitiyDTO((String) listFields.get(0), (String) listFields.get(1), (double) listFields.get(2), (long) listFields.get(3));
    }
}
