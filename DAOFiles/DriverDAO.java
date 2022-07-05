package DataAccess.DAOs;
import DataAccess.DTOs.DriverDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Driver;
import java.util.List;

public class DriverDAO extends DAO<PK, DriverDTO, Driver> {
    public DriverDAO() {
        super(DriverDTO.class, IM.getInstance().getIdentityMap(Driver.class));
    }
    @Override
    protected Driver convertDtoToBusiness(DriverDTO dto) {
        return new Driver((int) dto.getEmployeeId(), (String) dto.getLicense(), (String) dto.getLastUpdateDistance(), (int) dto.getDistance());
    }
    @Override
    protected DriverDTO convertBusinessToDto(Driver business) {
        return new DriverDTO(business.getEmployeeId(), business.getLicense(), business.getLastUpdateDistance(), business.getDistance());
    }
    @Override
    protected DriverDTO createDTO(List<Object> listFields) {
        return new DriverDTO((long) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (long) listFields.get(3));
    }
}
