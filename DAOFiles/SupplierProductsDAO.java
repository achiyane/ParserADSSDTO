import DataAccess.DTOs.SupplierProductsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierProducts;
import java.util.List;


public class SupplierProductsDAO extends DAO<PK, SupplierProductsDTO, SupplierProducts> {
    public SupplierProductsDA) {
        super(SupplierProductsDTO.class, IM.getInstance().getIdentityMap(SupplierProducts.class));
        
    }
    @Override
    protected SupplierProducts convertDtoToBusiness(SupplierProductsDTO dto) {
        return new SupplierProduct);
    }
    @Override
    protected SupplierProductsDTO convertBusinessToDto(SupplierProducts business) {
        return new SupplierProductsDT);
    }
    @Override
    protected SupplierProductsDTO createDTO(List<Object> listFields) {
        return new SupplierProductsDT);
    }
}
