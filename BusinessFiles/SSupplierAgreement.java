package Logic;
import DataAccess.DAOs.SupplierAgreementDAO;
import DataAccess.DTOs.SupplierAgreementDTO;

public class SupplierAgreement {
    private SupplierAgreementDAO supplieragreementDAO;
    private String cn;
    private String isConsistent;
    
    public SupplierAgreement(String cn, String isConsistent) {
        this.cn = cn;
        this.isConsistent = isConsistent;
        this.supplieragreementDAO = new SupplierAgreementDAO();
    }
    public String getCn() {
        return this.cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplieragreementDAO.update(this);
    }
    public String getIsConsistent() {
        return this.isConsistent;
    }
    public void setIsConsistent(String isConsistent) {
        this.isConsistent = isConsistent;
        this.supplieragreementDAO.update(this);
    }
    @Override
    public String toString(){
        return "SupplierAgreement{" +
        "cn = [" + this.cn + "], " +
        "isConsistent = [" + this.isConsistent + "], " +
        "}";
    }
    
}
