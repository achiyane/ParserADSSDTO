package DataAccess.DAOs;
import DataAccess.DTOs.ProductsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Products;
import java.util.List;

public class ProductsDAO extends DAO<PK, ProductsDTO, Products> {
    public ProductsDAO() {
        super(ProductsDTO.class, IM.getInstance().getIdentityMap(Products.class));
    }
    @Override
    protected Products convertDtoToBusiness(ProductsDTO dto) {
        return new Products((int) dto.getID(), (String) dto.getName(), (String) dto.getManufacturer(), (double) dto.getPrice(), (int) dto.getCategory_ID(), (int) dto.getDemand_per_day(), (int) dto.getItem_id_runner());
    }
    @Override
    protected ProductsDTO convertBusinessToDto(Products business) {
        return new ProductsDTO(business.getID(), business.getName(), business.getManufacturer(), business.getPrice(), business.getCategory_ID(), business.getDemand_per_day(), business.getItem_id_runner());
    }
    @Override
    protected ProductsDTO createDTO(List<Object> listFields) {
        return new ProductsDTO((long) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (double) listFields.get(3), (long) listFields.get(4), (long) listFields.get(5), (long) listFields.get(6));
    }
}
