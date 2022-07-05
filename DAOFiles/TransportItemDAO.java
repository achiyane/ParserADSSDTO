package DataAccess.DAOs;
import DataAccess.DTOs.TransportItemDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.TransportItem;
import java.util.List;

public class TransportItemDAO extends DAO<PK, TransportItemDTO, TransportItem> {
    public TransportItemDAO() {
        super(TransportItemDTO.class, IM.getInstance().getIdentityMap(TransportItem.class));
    }
    @Override
    protected TransportItem convertDtoToBusiness(TransportItemDTO dto) {
        return new TransportItem((String) dto.getName(), (int) dto.getQuantity(), (int) dto.getOrderTransportId(), (String) dto.getDestinationFileId());
    }
    @Override
    protected TransportItemDTO convertBusinessToDto(TransportItem business) {
        return new TransportItemDTO(business.getName(), business.getQuantity(), business.getOrderTransportId(), business.getDestinationFileId());
    }
    @Override
    protected TransportItemDTO createDTO(List<Object> listFields) {
        return new TransportItemDTO((String) listFields.get(0), (long) listFields.get(1), (long) listFields.get(2), (String) listFields.get(3));
    }
}
