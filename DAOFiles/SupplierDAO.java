package DataAccess.DAOs;
import DataAccess.DTOs.SupplierDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Supplier;
import java.util.List;

public class SupplierDAO extends DAO<PK, SupplierDTO, Supplier> {
    public SupplierDAO() {
        super(SupplierDTO.class, IM.getInstance().getIdentityMap(Supplier.class));
    }
    @Override
    protected Supplier convertDtoToBusiness(SupplierDTO dto) {
        return new Supplier((String) dto.getCn());
    }
    @Override
    protected SupplierDTO convertBusinessToDto(Supplier business) {
        return new SupplierDTO(business.getCn());
    }
    @Override
    protected SupplierDTO createDTO(List<Object> listFields) {
        return new SupplierDTO((String) listFields.get(0));
    }
}
