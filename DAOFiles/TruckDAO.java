import DataAccess.DTOs.TruckDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Truck;
import java.util.List;


public class TruckDAO extends DAO<PK, TruckDTO, Truck> {
    public TruckDA) {
        super(TruckDTO.class, IM.getInstance().getIdentityMap(Truck.class));
        
    }
    @Override
    protected Truck convertDtoToBusiness(TruckDTO dto) {
        return new Truc);
    }
    @Override
    protected TruckDTO convertBusinessToDto(Truck business) {
        return new TruckDT);
    }
    @Override
    protected TruckDTO createDTO(List<Object> listFields) {
        return new TruckDT);
    }
}
