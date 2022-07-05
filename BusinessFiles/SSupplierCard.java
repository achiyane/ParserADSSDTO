package Logic;
import DataAccess.DAOs.SupplierCardDAO;
import DataAccess.DTOs.SupplierCardDTO;

public class SupplierCard {
    private SupplierCardDAO suppliercardDAO;
    private String cn;
    private String supplierName;
    private String bankAccountNum;
    private String paymentMethod;
    private String paymentFrequency;
    private String address;
    
    public SupplierCard(String cn, String supplierName, String bankAccountNum, String paymentMethod, String paymentFrequency, String address) {
        this.cn = cn;
        this.supplierName = supplierName;
        this.bankAccountNum = bankAccountNum;
        this.paymentMethod = paymentMethod;
        this.paymentFrequency = paymentFrequency;
        this.address = address;
        this.suppliercardDAO = new SupplierCardDAO();
    }
    public String getCn() {
        return this.cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.suppliercardDAO.update(this);
    }
    public String getSupplierName() {
        return this.supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
        this.suppliercardDAO.update(this);
    }
    public String getBankAccountNum() {
        return this.bankAccountNum;
    }
    public void setBankAccountNum(String bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
        this.suppliercardDAO.update(this);
    }
    public String getPaymentMethod() {
        return this.paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        this.suppliercardDAO.update(this);
    }
    public String getPaymentFrequency() {
        return this.paymentFrequency;
    }
    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
        this.suppliercardDAO.update(this);
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
        this.suppliercardDAO.update(this);
    }
    @Override
    public String toString(){
        return "SupplierCard{" +
        "cn = [" + this.cn + "], " +
        "supplierName = [" + this.supplierName + "], " +
        "bankAccountNum = [" + this.bankAccountNum + "], " +
        "paymentMethod = [" + this.paymentMethod + "], " +
        "paymentFrequency = [" + this.paymentFrequency + "], " +
        "address = [" + this.address + "], " +
        "}";
    }
    
}
