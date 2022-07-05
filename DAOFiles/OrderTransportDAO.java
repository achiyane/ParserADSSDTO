package DataAccess.DAOs;
import DataAccess.DTOs.OrderTransportDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.OrderTransport;
import java.util.List;

public class OrderTransportDAO extends DAO<PK, OrderTransportDTO, OrderTransport> {
    public OrderTransportDAO() {
        super(OrderTransportDTO.class, IM.getInstance().getIdentityMap(OrderTransport.class));
    }
    @Override
    protected OrderTransport convertDtoToBusiness(OrderTransportDTO dto) {
        return new OrderTransport((int) dto.getOrderTransportId(), (String) dto.getOrigin(), (String) dto.getDestination(), (String) dto.getBasedOnCreationTime(), (String) dto.getSupplierID());
    }
    @Override
    protected OrderTransportDTO convertBusinessToDto(OrderTransport business) {
        return new OrderTransportDTO(business.getOrderTransportId(), business.getOrigin(), business.getDestination(), business.getBasedOnCreationTime(), business.getSupplierID());
    }
    @Override
    protected OrderTransportDTO createDTO(List<Object> listFields) {
        return new OrderTransportDTO((long) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (String) listFields.get(3), (String) listFields.get(4));
    }
}
