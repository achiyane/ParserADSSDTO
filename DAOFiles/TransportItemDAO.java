import DataAccess.DTOs.TransportItemDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.TransportItem;
import java.util.List;


public class TransportItemDAO extends DAO<PK, TransportItemDTO, TransportItem> {
    public TransportItemDA) {
        super(TransportItemDTO.class, IM.getInstance().getIdentityMap(TransportItem.class));
        
    }
    @Override
    protected TransportItem convertDtoToBusiness(TransportItemDTO dto) {
        return new TransportIte);
    }
    @Override
    protected TransportItemDTO convertBusinessToDto(TransportItem business) {
        return new TransportItemDT);
    }
    @Override
    protected TransportItemDTO createDTO(List<Object> listFields) {
        return new TransportItemDT);
    }
}
