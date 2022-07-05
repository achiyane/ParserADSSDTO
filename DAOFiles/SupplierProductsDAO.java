package DataAccess.DAOs;
import DataAccess.DTOs.SupplierProductsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierProducts;
import java.util.List;

public class SupplierProductsDAO extends DAO<PK, SupplierProductsDTO, SupplierProducts> {
    public SupplierProductsDAO() {
        super(SupplierProductsDTO.class, IM.getInstance().getIdentityMap(SupplierProducts.class));
    }
    @Override
    protected SupplierProducts convertDtoToBusiness(SupplierProductsDTO dto) {
        return new SupplierProducts((String) dto.getCn(), (String) dto.getProductName(), (double) dto.getPrice(), (String) dto.getCatalogNum());
    }
    @Override
    protected SupplierProductsDTO convertBusinessToDto(SupplierProducts business) {
        return new SupplierProductsDTO(business.getCn(), business.getProductName(), business.getPrice(), business.getCatalogNum());
    }
    @Override
    protected SupplierProductsDTO createDTO(List<Object> listFields) {
        return new SupplierProductsDTO((String) listFields.get(0), (String) listFields.get(1), (double) listFields.get(2), (String) listFields.get(3));
    }
}
