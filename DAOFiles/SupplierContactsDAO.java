import DataAccess.DTOs.SupplierContactsDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.SupplierContacts;
import java.util.List;


public class SupplierContactsDAO extends DAO<PK, SupplierContactsDTO, SupplierContacts> {
    public SupplierContactsDA) {
        super(SupplierContactsDTO.class, IM.getInstance().getIdentityMap(SupplierContacts.class));
        
    }
    @Override
    protected SupplierContacts convertDtoToBusiness(SupplierContactsDTO dto) {
        return new SupplierContact);
    }
    @Override
    protected SupplierContactsDTO convertBusinessToDto(SupplierContacts business) {
        return new SupplierContactsDT);
    }
    @Override
    protected SupplierContactsDTO createDTO(List<Object> listFields) {
        return new SupplierContactsDT);
    }
}
