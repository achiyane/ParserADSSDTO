import DataAccess.DTOs.PointDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Point;
import java.util.List;


public class PointDAO extends DAO<PK, PointDTO, Point> {
    public PointDA) {
        super(PointDTO.class, IM.getInstance().getIdentityMap(Point.class));
        
    }
    @Override
    protected Point convertDtoToBusiness(PointDTO dto) {
        return new Poin);
    }
    @Override
    protected PointDTO convertBusinessToDto(Point business) {
        return new PointDT);
    }
    @Override
    protected PointDTO createDTO(List<Object> listFields) {
        return new PointDT);
    }
}
