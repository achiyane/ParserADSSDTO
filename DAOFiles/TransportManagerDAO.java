package DataAccess.DAOs;
import DataAccess.DTOs.TransportManagerDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.TransportManager;
import java.util.List;

public class TransportManagerDAO extends DAO<PK, TransportManagerDTO, TransportManager> {
    public TransportManagerDAO() {
        super(TransportManagerDTO.class, IM.getInstance().getIdentityMap(TransportManager.class));
    }
    @Override
    protected TransportManager convertDtoToBusiness(TransportManagerDTO dto) {
        return new TransportManager((int) dto.getEmployeeId());
    }
    @Override
    protected TransportManagerDTO convertBusinessToDto(TransportManager business) {
        return new TransportManagerDTO(business.getEmployeeId());
    }
    @Override
    protected TransportManagerDTO createDTO(List<Object> listFields) {
        return new TransportManagerDTO((long) listFields.get(0));
    }
}
