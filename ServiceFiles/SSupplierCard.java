package Service.Objects;

public class SSupplierCard {
    private String cn;
    private String supplierName;
    private String bankAccountNum;
    private String paymentMethod;
    private String paymentFrequency;
    private String address;
    public SSupplierCard(String cn, String supplierName, String bankAccountNum, String paymentMethod, String paymentFrequency, String address) {
        
        this.cn = cn;
        this.supplierName = supplierName;
        this.bankAccountNum = bankAccountNum;
        this.paymentMethod = paymentMethod;
        this.paymentFrequency = paymentFrequency;
        this.address = address;
    }
    
    public SSupplierCard(SupplierCard business) {
        this.cn = business.getCn();
        this.supplierName = business.getSupplierName();
        this.bankAccountNum = business.getBankAccountNum();
        this.paymentMethod = business.getPaymentMethod();
        this.paymentFrequency = business.getPaymentFrequency();
        this.address = business.getAddress();
    }
    
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public String getBankAccountNum() {
        return bankAccountNum;
    }
    public void setBankAccountNum(String bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public String getPaymentFrequency() {
        return paymentFrequency;
    }
    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "SupplierCard{cn = [" + this.cn"], " +
        "supplierName = [" + this.supplierName"], " +
        "bankAccountNum = [" + this.bankAccountNum"], " +
        "paymentMethod = [" + this.paymentMethod"], " +
        "paymentFrequency = [" + this.paymentFrequency"], " +
        "address = [" + this.address"],  " +
        "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SSupplierCard)) return false;
        SSupplierCard that = (SSupplierCard) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getSupplierName(), (that.getSupplierName())) && Object.equals(getBankAccountNum(), (that.getBankAccountNum())) && Object.equals(getPaymentMethod(), (that.getPaymentMethod())) && Object.equals(getPaymentFrequency(), (that.getPaymentFrequency())) && Object.equals(getAddress(), (that.getAddress()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getSupplierName(), getBankAccountNum(), getPaymentMethod(), getPaymentFrequency(), getAddress());
    }
}
