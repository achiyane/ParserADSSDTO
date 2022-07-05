import DataAccess.DTOs.SupplierDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.Supplier;
import java.util.List;


public class SupplierDAO extends DAO<PK, SupplierDTO, Supplier> {
    public SupplierDA) {
        super(SupplierDTO.class, IM.getInstance().getIdentityMap(Supplier.class));
        
    }
    @Override
    protected Supplier convertDtoToBusiness(SupplierDTO dto) {
        return new Supplie);
    }
    @Override
    protected SupplierDTO convertBusinessToDto(Supplier business) {
        return new SupplierDT);
    }
    @Override
    protected SupplierDTO createDTO(List<Object> listFields) {
        return new SupplierDT);
    }
}
