package DataAccess.DAOs;
import DataAccess.DTOs.ProductOrderDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.ProductOrder;
import java.util.List;

public class ProductOrderDAO extends DAO<PK, ProductOrderDTO, ProductOrder> {
    public ProductOrderDAO() {
        super(ProductOrderDTO.class, IM.getInstance().getIdentityMap(ProductOrder.class));
    }
    @Override
    protected ProductOrder convertDtoToBusiness(ProductOrderDTO dto) {
        return new ProductOrder((int) dto.getOrderID(), (String) dto.getCatalogNum(), (String) dto.getProductName(), (int) dto.getQuantity(), (double) dto.getTotalPriceWithoutDiscount(), (double) dto.getDiscount(), (double) dto.getFinalPrice());
    }
    @Override
    protected ProductOrderDTO convertBusinessToDto(ProductOrder business) {
        return new ProductOrderDTO(business.getOrderID(), business.getCatalogNum(), business.getProductName(), business.getQuantity(), business.getTotalPriceWithoutDiscount(), business.getDiscount(), business.getFinalPrice());
    }
    @Override
    protected ProductOrderDTO createDTO(List<Object> listFields) {
        return new ProductOrderDTO((long) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (long) listFields.get(3), (double) listFields.get(4), (double) listFields.get(5), (double) listFields.get(6));
    }
}
