import DataAccess.DTOs.SupplierOrdersDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierOrders;
import java.util.List;


public class SupplierOrdersDAO extends DAO<PK, SupplierOrdersDTO, SupplierOrders> {
    public SupplierOrdersDA) {
        super(SupplierOrdersDTO.class, IM.getInstance().getIdentityMap(SupplierOrders.class));
        
    }
    @Override
    protected SupplierOrders convertDtoToBusiness(SupplierOrdersDTO dto) {
        return new SupplierOrder);
    }
    @Override
    protected SupplierOrdersDTO convertBusinessToDto(SupplierOrders business) {
        return new SupplierOrdersDT);
    }
    @Override
    protected SupplierOrdersDTO createDTO(List<Object> listFields) {
        return new SupplierOrdersDT);
    }
}
