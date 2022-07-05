package DataAccess.DAOs;
import DataAccess.DTOs.BankAccountDTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.BankAccount;
import java.util.List;

public class BankAccountDAO extends DAO<PK, BankAccountDTO, BankAccount> {
    public BankAccountDAO() {
        super(BankAccountDTO.class, IM.getInstance().getIdentityMap(BankAccount.class));
    }
    @Override
    protected BankAccount convertDtoToBusiness(BankAccountDTO dto) {
        return new BankAccount((int) dto.getEmployeeId(), (int) dto.getBankNumber(), (int) dto.getBankBranch(), (int) dto.getAccountNumber());
    }
    @Override
    protected BankAccountDTO convertBusinessToDto(BankAccount business) {
        return new BankAccountDTO(business.getEmployeeId(), business.getBankNumber(), business.getBankBranch(), business.getAccountNumber());
    }
    @Override
    protected BankAccountDTO createDTO(List<Object> listFields) {
        return new BankAccountDTO((long) listFields.get(0), (long) listFields.get(1), (long) listFields.get(2), (long) listFields.get(3));
    }
}
