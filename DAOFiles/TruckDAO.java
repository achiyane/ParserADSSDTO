package DataAccess.DAOs;
import DataAccess.DTOs.TruckDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Truck;
import java.util.List;

public class TruckDAO extends DAO<PK, TruckDTO, Truck> {
    public TruckDAO() {
        super(TruckDTO.class, IM.getInstance().getIdentityMap(Truck.class));
    }
    @Override
    protected Truck convertDtoToBusiness(TruckDTO dto) {
        return new Truck((int) dto.getTruckId(), (String) dto.getModel(), (int) dto.getBasicWeight(), (int) dto.getMaxWeight(), (String) dto.getLicense());
    }
    @Override
    protected TruckDTO convertBusinessToDto(Truck business) {
        return new TruckDTO(business.getTruckId(), business.getModel(), business.getBasicWeight(), business.getMaxWeight(), business.getLicense());
    }
    @Override
    protected TruckDTO createDTO(List<Object> listFields) {
        return new TruckDTO((long) listFields.get(0), (String) listFields.get(1), (long) listFields.get(2), (long) listFields.get(3), (String) listFields.get(4));
    }
}
