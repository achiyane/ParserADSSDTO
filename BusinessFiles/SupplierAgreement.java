package Logic;
import DataAccess.DAOs.SupplierAgreementDAO;
import DataAccess.DTOs.SupplierAgreementDTO;

public class SupplierAgreement {
    private String cn;
    private String isConsistent;
    private SupplierAgreementDAO supplierAgreementDAO;
    public SupplierAgreement(String cn, String isConsistent) {
        
        this.cn = cn;
        this.isConsistent = isConsistent;
        this.supplierAgreementDAO = new SupplierAgreementDAO();
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierAgreementDAO.update(this);
    }
    public String getIsConsistent() {
        return isConsistent;
    }
    public void setIsConsistent(String isConsistent) {
        this.isConsistent = isConsistent;
        this.supplierAgreementDAO.update(this);
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
        if (!(o instanceof SupplierAgreement)) return false;
        SupplierAgreement that = (SupplierAgreement) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getIsConsistent(), (that.getIsConsistent()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getIsConsistent());
    }
    
}
