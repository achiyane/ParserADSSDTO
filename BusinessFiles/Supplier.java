package Logic;
import DataAccess.DAOs.SupplierDAO;
import DataAccess.DTOs.SupplierDTO;

public class Supplier {
    private String cn;
    private SupplierDAO supplierDAO;
    public Supplier(String cn) {
        
        this.cn = cn;
        this.supplierDAO = new SupplierDAO();
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierDAO.update(this);
    }
    @Override
    public String toString() {
        return "Supplier{cn = [" + this.cn"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;
        Supplier that = (Supplier) o;
        return Object.equals(getCn(), (that.getCn()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getCn());
    }
    
}
