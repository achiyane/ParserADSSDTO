package DataAccess.DAOs;
import DataAccess.DTOs.PointDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Point;
import java.util.List;

public class PointDAO extends DAO<PK, PointDTO, Point> {
    public PointDAO() {
        super(PointDTO.class, IM.getInstance().getIdentityMap(Point.class));
    }
    @Override
    protected Point convertDtoToBusiness(PointDTO dto) {
        return new Point((String) dto.getAddress(), (String) dto.getPhone(), (String) dto.getContactName(), (String) dto.getZone(), (String) dto.getTag());
    }
    @Override
    protected PointDTO convertBusinessToDto(Point business) {
        return new PointDTO(business.getAddress(), business.getPhone(), business.getContactName(), business.getZone(), business.getTag());
    }
    @Override
    protected PointDTO createDTO(List<Object> listFields) {
        return new PointDTO((String) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (String) listFields.get(3), (String) listFields.get(4));
    }
}
