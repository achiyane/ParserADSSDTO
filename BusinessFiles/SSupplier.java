package Logic;
import DataAccess.DAOs.SupplierDAO;
import DataAccess.DTOs.SupplierDTO;

public class Supplier {
    private SupplierDAO supplierDAO;
    private String cn;
    
    public Supplier(String cn) {
        this.cn = cn;
        this.supplierDAO = new SupplierDAO();
    }
    public String getCn() {
        return this.cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierDAO.update(this);
    }
    @Override
    public String toString(){
        return "Supplier{" +
        "cn = [" + this.cn + "], " +
        "}";
    }
    
}
