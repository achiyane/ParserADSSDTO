package DataAccess.DAOs;
import DataAccess.DTOs.DestinationFileDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.DestinationFile;
import java.util.List;

public class DestinationFileDAO extends DAO<PK, DestinationFileDTO, DestinationFile> {
    public DestinationFileDAO() {
        super(DestinationFileDTO.class, IM.getInstance().getIdentityMap(DestinationFile.class));
    }
    @Override
    protected DestinationFile convertDtoToBusiness(DestinationFileDTO dto) {
        return new DestinationFile((String) dto.getId(), (String) dto.getSource(), (String) dto.getDestination(), (int) dto.getIsDone(), (String) dto.getCreationBased(), (String) dto.getArrivalDate(), (int) dto.getTransportId(), (String) dto.getSupplierID());
    }
    @Override
    protected DestinationFileDTO convertBusinessToDto(DestinationFile business) {
        return new DestinationFileDTO(business.getId(), business.getSource(), business.getDestination(), business.getIsDone(), business.getCreationBased(), business.getArrivalDate(), business.getTransportId(), business.getSupplierID());
    }
    @Override
    protected DestinationFileDTO createDTO(List<Object> listFields) {
        return new DestinationFileDTO((String) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (long) listFields.get(3), (String) listFields.get(4), (String) listFields.get(5), (long) listFields.get(6), (String) listFields.get(7));
    }
}
