import DataAccess.DTOs.DriverDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Driver;
import java.util.List;


public class DriverDAO extends DAO<PK, DriverDTO, Driver> {
    public DriverDA) {
        super(DriverDTO.class, IM.getInstance().getIdentityMap(Driver.class));
        
    }
    @Override
    protected Driver convertDtoToBusiness(DriverDTO dto) {
        return new Drive);
    }
    @Override
    protected DriverDTO convertBusinessToDto(Driver business) {
        return new DriverDT);
    }
    @Override
    protected DriverDTO createDTO(List<Object> listFields) {
        return new DriverDT);
    }
}
