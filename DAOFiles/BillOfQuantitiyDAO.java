import DataAccess.DTOs.BillOfQuantitiyDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.BillOfQuantitiy;
import java.util.List;


public class BillOfQuantitiyDAO extends DAO<PK, BillOfQuantitiyDTO, BillOfQuantitiy> {
    public BillOfQuantitiyDA) {
        super(BillOfQuantitiyDTO.class, IM.getInstance().getIdentityMap(BillOfQuantitiy.class));
        
    }
    @Override
    protected BillOfQuantitiy convertDtoToBusiness(BillOfQuantitiyDTO dto) {
        return new BillOfQuantiti);
    }
    @Override
    protected BillOfQuantitiyDTO convertBusinessToDto(BillOfQuantitiy business) {
        return new BillOfQuantitiyDT);
    }
    @Override
    protected BillOfQuantitiyDTO createDTO(List<Object> listFields) {
        return new BillOfQuantitiyDT);
    }
}
