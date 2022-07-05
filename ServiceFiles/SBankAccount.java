package Service.Objects;

public class SBankAccount {
    private int employeeId;
    private int bankNumber;
    private int bankBranch;
    private int accountNumber;
    public SBankAccount(int employeeId, int bankNumber, int bankBranch, int accountNumber) {
        
        this.employeeId = employeeId;
        this.bankNumber = bankNumber;
        this.bankBranch = bankBranch;
        this.accountNumber = accountNumber;
    }
    
    public SBankAccount(BankAccount business) {
        this.employeeId = business.getEmployeeId();
        this.bankNumber = business.getBankNumber();
        this.bankBranch = business.getBankBranch();
        this.accountNumber = business.getAccountNumber();
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public int getBankNumber() {
        return bankNumber;
    }
    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }
    public int getBankBranch() {
        return bankBranch;
    }
    public void setBankBranch(int bankBranch) {
        this.bankBranch = bankBranch;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SBankAccount)) return false;
        SBankAccount that = (SBankAccount) o;
        return Object.equals(getEmployeeId(), (that.getEmployeeId())) && Object.equals(getBankNumber(), (that.getBankNumber())) && Object.equals(getBankBranch(), (that.getBankBranch())) && Object.equals(getAccountNumber(), (that.getAccountNumber()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getBankNumber(), getBankBranch(), getAccountNumber());
    }
}
