package DataAccess.DAOs;
import DataAccess.DTOs.SupplierContactsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierContacts;
import java.util.List;

public class SupplierContactsDAO extends DAO<PK, SupplierContactsDTO, SupplierContacts> {
    public SupplierContactsDAO() {
        super(SupplierContactsDTO.class, IM.getInstance().getIdentityMap(SupplierContacts.class));
    }
    @Override
    protected SupplierContacts convertDtoToBusiness(SupplierContactsDTO dto) {
        return new SupplierContacts((String) dto.getCn(), (String) dto.getContactPhoneNumber(), (String) dto.getContactName(), (String) dto.getContactEmail());
    }
    @Override
    protected SupplierContactsDTO convertBusinessToDto(SupplierContacts business) {
        return new SupplierContactsDTO(business.getCn(), business.getContactPhoneNumber(), business.getContactName(), business.getContactEmail());
    }
    @Override
    protected SupplierContactsDTO createDTO(List<Object> listFields) {
        return new SupplierContactsDTO((String) listFields.get(0), (String) listFields.get(1), (String) listFields.get(2), (String) listFields.get(3));
    }
}
