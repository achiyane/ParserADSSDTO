import DataAccess.DTOs.BankAccountDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.BankAccount;
import java.util.List;


public class BankAccountDAO extends DAO<PK, BankAccountDTO, BankAccount> {
    public BankAccountDA) {
        super(BankAccountDTO.class, IM.getInstance().getIdentityMap(BankAccount.class));
        
    }
    @Override
    protected BankAccount convertDtoToBusiness(BankAccountDTO dto) {
        return new BankAccoun);
    }
    @Override
    protected BankAccountDTO convertBusinessToDto(BankAccount business) {
        return new BankAccountDT);
    }
    @Override
    protected BankAccountDTO createDTO(List<Object> listFields) {
        return new BankAccountDT);
    }
}
