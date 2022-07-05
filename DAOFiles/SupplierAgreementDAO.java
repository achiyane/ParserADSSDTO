import DataAccess.DTOs.SupplierAgreementDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierAgreement;
import java.util.List;


public class SupplierAgreementDAO extends DAO<PK, SupplierAgreementDTO, SupplierAgreement> {
    public SupplierAgreementDA) {
        super(SupplierAgreementDTO.class, IM.getInstance().getIdentityMap(SupplierAgreement.class));
        
    }
    @Override
    protected SupplierAgreement convertDtoToBusiness(SupplierAgreementDTO dto) {
        return new SupplierAgreemen);
    }
    @Override
    protected SupplierAgreementDTO convertBusinessToDto(SupplierAgreement business) {
        return new SupplierAgreementDT);
    }
    @Override
    protected SupplierAgreementDTO createDTO(List<Object> listFields) {
        return new SupplierAgreementDT);
    }
}
