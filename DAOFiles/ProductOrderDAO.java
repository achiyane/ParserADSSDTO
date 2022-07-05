import DataAccess.DTOs.ProductOrderDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.ProductOrder;
import java.util.List;


public class ProductOrderDAO extends DAO<PK, ProductOrderDTO, ProductOrder> {
    public ProductOrderDA) {
        super(ProductOrderDTO.class, IM.getInstance().getIdentityMap(ProductOrder.class));
        
    }
    @Override
    protected ProductOrder convertDtoToBusiness(ProductOrderDTO dto) {
        return new ProductOrde);
    }
    @Override
    protected ProductOrderDTO convertBusinessToDto(ProductOrder business) {
        return new ProductOrderDT);
    }
    @Override
    protected ProductOrderDTO createDTO(List<Object> listFields) {
        return new ProductOrderDT);
    }
}
