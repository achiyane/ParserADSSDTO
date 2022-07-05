import DataAccess.DTOs.CategoriesDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Categories;
import java.util.List;


public class CategoriesDAO extends DAO<PK, CategoriesDTO, Categories> {
    public CategoriesDA) {
        super(CategoriesDTO.class, IM.getInstance().getIdentityMap(Categories.class));
        
    }
    @Override
    protected Categories convertDtoToBusiness(CategoriesDTO dto) {
        return new Categorie);
    }
    @Override
    protected CategoriesDTO convertBusinessToDto(Categories business) {
        return new CategoriesDT);
    }
    @Override
    protected CategoriesDTO createDTO(List<Object> listFields) {
        return new CategoriesDT);
    }
}
