package DataAccess.DAOs;
import DataAccess.DTOs.CategoriesDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Categories;
import java.util.List;

public class CategoriesDAO extends DAO<PK, CategoriesDTO, Categories> {
    public CategoriesDAO() {
        super(CategoriesDTO.class, IM.getInstance().getIdentityMap(Categories.class));
    }
    @Override
    protected Categories convertDtoToBusiness(CategoriesDTO dto) {
        return new Categories((int) dto.getID(), (int) dto.getParent_ID(), (String) dto.getName());
    }
    @Override
    protected CategoriesDTO convertBusinessToDto(Categories business) {
        return new CategoriesDTO(business.getID(), business.getParent_ID(), business.getName());
    }
    @Override
    protected CategoriesDTO createDTO(List<Object> listFields) {
        return new CategoriesDTO((long) listFields.get(0), (long) listFields.get(1), (String) listFields.get(2));
    }
}
