import DataAccess.DTOs.OrderTransportDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.OrderTransport;
import java.util.List;


public class OrderTransportDAO extends DAO<PK, OrderTransportDTO, OrderTransport> {
    public OrderTransportDA) {
        super(OrderTransportDTO.class, IM.getInstance().getIdentityMap(OrderTransport.class));
        
    }
    @Override
    protected OrderTransport convertDtoToBusiness(OrderTransportDTO dto) {
        return new OrderTranspor);
    }
    @Override
    protected OrderTransportDTO convertBusinessToDto(OrderTransport business) {
        return new OrderTransportDT);
    }
    @Override
    protected OrderTransportDTO createDTO(List<Object> listFields) {
        return new OrderTransportDT);
    }
}
