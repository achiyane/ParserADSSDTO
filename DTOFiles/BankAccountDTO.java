package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class BankAccountDTO extends DTO<PK> {
    private long employeeId;
    private long bankNumber;
    private long bankBranch;
    private long accountNumber;
    
    public BankAccountDTO(long employeeId, long bankNumber, long bankBranch, long accountNumber) {
        super(new PK(getFields(), employeeId));
        
        this.employeeId = employeeId;
        this.bankNumber = bankNumber;
        this.bankBranch = bankBranch;
        this.accountNumber = accountNumber;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"employeeId"}, BankAccountDTO.class);
    }
    public static PK getPK(long employeeId) {
        return new PK(getFields(), employeeId);
    }
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public long getBankNumber() {
        return bankNumber;
    }
    public void setBankNumber(long bankNumber) {
        this.bankNumber = bankNumber;
    }
    public long getBankBranch() {
        return bankBranch;
    }
    public void setBankBranch(long bankBranch) {
        this.bankBranch = bankBranch;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    @Override
    public String toString() {
        return "BankAccount{employeeId = [" + this.employeeId"], " +
        "bankNumber = [" + this.bankNumber"], " +
        "bankBranch = [" + this.bankBranch"], " +
        "accountNumber = [" + this.accountNumber"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.employeeId, this.bankNumber, this.bankBranch, this.accountNumber};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccountDTO)) return false;
        BankAccountDTO that = (BankAccountDTO) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getBankNumber(), (that.getBankNumber())) && Object.equals(getBankBranch(), (that.getBankBranch())) && Object.equals(getAccountNumber(), (that.getAccountNumber()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getBankNumber(), getBankBranch(), getAccountNumber());
    }
}
