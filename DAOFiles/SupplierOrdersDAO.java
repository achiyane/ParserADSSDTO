package DataAccess.DAOs;
import DataAccess.DTOs.SupplierOrdersDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierOrders;
import java.util.List;

public class SupplierOrdersDAO extends DAO<PK, SupplierOrdersDTO, SupplierOrders> {
    public SupplierOrdersDAO() {
        super(SupplierOrdersDTO.class, IM.getInstance().getIdentityMap(SupplierOrders.class));
    }
    @Override
    protected SupplierOrders convertDtoToBusiness(SupplierOrdersDTO dto) {
        return new SupplierOrders((int) dto.getOrderID(), (String) dto.getCn(), (String) dto.getSupplierName(), (String) dto.getFromAddress(), (String) dto.getToAddress(), (String) dto.getDate(), (String) dto.getContactPhoneNumber(), (int) dto.getTransportID());
    }
    @Override
    protected SupplierOrdersDTO convertBusinessToDto(SupplierOrders business) {
        return new SupplierOrdersDTO(business.getOrderID(), business.getCn(), business.getSupplierName(), business.getFromAddress(), business.getToAddress(), business.getDate(), business.getContactPhoneNumber(), business.getTransportID());
    }
    @Override
    protected SupplierOrdersDTO createDTO(List<Object> listFields) {
        return new SupplierOrdersDTO((long) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (String) listFields.get(3), (String) listFields.get(4), (String) listFields.get(5), (String) listFields.get(6), (long) listFields.get(7));
    }
}
