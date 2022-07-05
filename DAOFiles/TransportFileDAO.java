package DataAccess.DAOs;
import DataAccess.DTOs.TransportFileDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.TransportFile;
import java.util.List;

public class TransportFileDAO extends DAO<PK, TransportFileDTO, TransportFile> {
    public TransportFileDAO() {
        super(TransportFileDTO.class, IM.getInstance().getIdentityMap(TransportFile.class));
    }
    @Override
    protected TransportFile convertDtoToBusiness(TransportFileDTO dto) {
        return new TransportFile((int) dto.getId(), (int) dto.getStarted(), (String) dto.getStartingDate(), (String) dto.getEndDate(), (int) dto.getDriverId(), (int) dto.getTruckId(), (String) dto.getSource(), (int) dto.getStartingWeight(), (String) dto.getFromZone(), (String) dto.getToZone(), (String) dto.getComment(), (int) dto.getIsFinish());
    }
    @Override
    protected TransportFileDTO convertBusinessToDto(TransportFile business) {
        return new TransportFileDTO(business.getId(), business.getStarted(), business.getStartingDate(), business.getEndDate(), business.getDriverId(), business.getTruckId(), business.getSource(), business.getStartingWeight(), business.getFromZone(), business.getToZone(), business.getComment(), business.getIsFinish());
    }
    @Override
    protected TransportFileDTO createDTO(List<Object> listFields) {
        return new TransportFileDTO((long) listFields.get(0), (long) listFields.get(1), (String) listFields.get(2), (String) listFields.get(3), (long) listFields.get(4), (long) listFields.get(5), (String) listFields.get(6), (long) listFields.get(7), (String) listFields.get(8), (String) listFields.get(9), (String) listFields.get(10), (long) listFields.get(11));
    }
}
