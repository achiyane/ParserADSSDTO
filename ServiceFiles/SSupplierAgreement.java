package Service.Objects;

public class SSupplierAgreement {
    private String cn;
    private String isConsistent;
    public SSupplierAgreement(String cn, String isConsistent) {
        
        this.cn = cn;
        this.isConsistent = isConsistent;
    }
    
    public SSupplierAgreement(SupplierAgreement business) {
        this.cn = business.getCn();
        this.isConsistent = business.getIsConsistent();
    }
    
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    public String getIsConsistent() {
        return isConsistent;
    }
    public void setIsConsistent(String isConsistent) {
        this.isConsistent = isConsistent;
    }
    
    @Override
    public String toString() {
        return "SupplierAgreement{cn = [" + this.cn"], " +
        "isConsistent = [" + this.isConsistent"],  " +
        "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SSupplierAgreement)) return false;
        SSupplierAgreement that = (SSupplierAgreement) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getIsConsistent(), (that.getIsConsistent()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getIsConsistent());
    }
}
