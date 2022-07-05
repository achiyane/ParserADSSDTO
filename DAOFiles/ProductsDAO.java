import DataAccess.DTOs.ProductsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Products;
import java.util.List;
import DataAccess.DAOs.LocationsDAO;


public class ProductsDAO extends DAO<PK, ProductsDTO, Products> {
    private LocationsDAO LocationsDAO;
    public ProductsDA) {
        super(ProductsDTO.class, IM.getInstance().getIdentityMap(Products.class));
        
        this.LocationsDAO = new LocationsDAO();
    }
    @Override
    protected Products convertDtoToBusiness(ProductsDTO dto) {
        return new Products((LocationsDAO) dto.getLocationsDAO());
    }
    @Override
    protected ProductsDTO convertBusinessToDto(Products business) {
        return new ProductsDTO(business.getLocationsDAO());
    }
    @Override
    protected ProductsDTO createDTO(List<Object> listFields) {
        return new ProductsDTO((LocationsDAO) listFields.get(0));
    }
    public List<Locations> getAllLocationss(int ID){
        return LocationsDAO.selectAllUnderConditionToBusiness("product_ID = " + ID);
        
    }
}
