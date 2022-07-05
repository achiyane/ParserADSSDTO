import DataAccess.DTOs.DestinationFileDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.DestinationFile;
import java.util.List;


public class DestinationFileDAO extends DAO<PK, DestinationFileDTO, DestinationFile> {
    public DestinationFileDA) {
        super(DestinationFileDTO.class, IM.getInstance().getIdentityMap(DestinationFile.class));
        
    }
    @Override
    protected DestinationFile convertDtoToBusiness(DestinationFileDTO dto) {
        return new DestinationFil);
    }
    @Override
    protected DestinationFileDTO convertBusinessToDto(DestinationFile business) {
        return new DestinationFileDT);
    }
    @Override
    protected DestinationFileDTO createDTO(List<Object> listFields) {
        return new DestinationFileDT);
    }
}
