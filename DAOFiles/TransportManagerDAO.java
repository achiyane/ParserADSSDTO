import DataAccess.DTOs.TransportManagerDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.TransportManager;
import java.util.List;


public class TransportManagerDAO extends DAO<PK, TransportManagerDTO, TransportManager> {
    public TransportManagerDA) {
        super(TransportManagerDTO.class, IM.getInstance().getIdentityMap(TransportManager.class));
        
    }
    @Override
    protected TransportManager convertDtoToBusiness(TransportManagerDTO dto) {
        return new TransportManage);
    }
    @Override
    protected TransportManagerDTO convertBusinessToDto(TransportManager business) {
        return new TransportManagerDT);
    }
    @Override
    protected TransportManagerDTO createDTO(List<Object> listFields) {
        return new TransportManagerDT);
    }
}
