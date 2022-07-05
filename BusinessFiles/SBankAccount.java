package Logic;
import DataAccess.DAOs.BankAccountDAO;
import DataAccess.DTOs.BankAccountDTO;

public class BankAccount {
    private BankAccountDAO bankaccountDAO;
    private long employeeId;
    private long bankNumber;
    private long bankBranch;
    private long accountNumber;
    
    public BankAccount(long employeeId, long bankNumber, long bankBranch, long accountNumber) {
        this.employeeId = employeeId;
        this.bankNumber = bankNumber;
        this.bankBranch = bankBranch;
        this.accountNumber = accountNumber;
        this.bankaccountDAO = new BankAccountDAO();
    }
    public long getEmployeeId() {
        return this.employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
        this.bankaccountDAO.update(this);
    }
    public long getBankNumber() {
        return this.bankNumber;
    }
    public void setBankNumber(long bankNumber) {
        this.bankNumber = bankNumber;
        this.bankaccountDAO.update(this);
    }
    public long getBankBranch() {
        return this.bankBranch;
    }
    public void setBankBranch(long bankBranch) {
        this.bankBranch = bankBranch;
        this.bankaccountDAO.update(this);
    }
    public long getAccountNumber() {
        return this.accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
        this.bankaccountDAO.update(this);
    }
    @Override
    public String toString(){
        return "BankAccount{" +
        "employeeId = [" + this.employeeId + "], " +
        "bankNumber = [" + this.bankNumber + "], " +
        "bankBranch = [" + this.bankBranch + "], " +
        "accountNumber = [" + this.accountNumber + "], " +
        "}";
    }
    
}
