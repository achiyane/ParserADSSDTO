package DataAccess.DAOs;
import DataAccess.DTOs.SupplierAgreementDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierAgreement;
import java.util.List;

public class SupplierAgreementDAO extends DAO<PK, SupplierAgreementDTO, SupplierAgreement> {
    public SupplierAgreementDAO() {
        super(SupplierAgreementDTO.class, IM.getInstance().getIdentityMap(SupplierAgreement.class));
    }
    @Override
    protected SupplierAgreement convertDtoToBusiness(SupplierAgreementDTO dto) {
        return new SupplierAgreement((String) dto.getCn(), (String) dto.getIsConsistent());
    }
    @Override
    protected SupplierAgreementDTO convertBusinessToDto(SupplierAgreement business) {
        return new SupplierAgreementDTO(business.getCn(), business.getIsConsistent());
    }
    @Override
    protected SupplierAgreementDTO createDTO(List<Object> listFields) {
        return new SupplierAgreementDTO((String) listFields.get(0), (String) listFields.get(1));
    }
}
