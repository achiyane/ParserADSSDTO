import DataAccess.DTOs.TransportFileDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.TransportFile;
import java.util.List;


public class TransportFileDAO extends DAO<PK, TransportFileDTO, TransportFile> {
    public TransportFileDA) {
        super(TransportFileDTO.class, IM.getInstance().getIdentityMap(TransportFile.class));
        
    }
    @Override
    protected TransportFile convertDtoToBusiness(TransportFileDTO dto) {
        return new TransportFil);
    }
    @Override
    protected TransportFileDTO convertBusinessToDto(TransportFile business) {
        return new TransportFileDT);
    }
    @Override
    protected TransportFileDTO createDTO(List<Object> listFields) {
        return new TransportFileDT);
    }
}
