package Logic;
import DataAccess.DAOs.BankAccountDAO;
import DataAccess.DTOs.BankAccountDTO;

public class BankAccount {
    private int employeeId;
    private int bankNumber;
    private int bankBranch;
    private int accountNumber;
    private BankAccountDAO bankAccountDAO;
    public BankAccount(int employeeId, int bankNumber, int bankBranch, int accountNumber) {
        
        this.employeeId = employeeId;
        this.bankNumber = bankNumber;
        this.bankBranch = bankBranch;
        this.accountNumber = accountNumber;
        this.bankAccountDAO = new BankAccountDAO();
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        this.bankAccountDAO.update(this);
    }
    public int getBankNumber() {
        return bankNumber;
    }
    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
        this.bankAccountDAO.update(this);
    }
    public int getBankBranch() {
        return bankBranch;
    }
    public void setBankBranch(int bankBranch) {
        this.bankBranch = bankBranch;
        this.bankAccountDAO.update(this);
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
        this.bankAccountDAO.update(this);
    }
    @Override
    public String toString() {
        return "BankAccount{employeeId = [" + this.employeeId"], " +
        "bankNumber = [" + this.bankNumber"], " +
        "bankBranch = [" + this.bankBranch"], " +
        "accountNumber = [" + this.accountNumber"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getBankNumber(), (that.getBankNumber())) && Object.equals(getBankBranch(), (that.getBankBranch())) && Object.equals(getAccountNumber(), (that.getAccountNumber()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getBankNumber(), getBankBranch(), getAccountNumber());
    }
    
}
