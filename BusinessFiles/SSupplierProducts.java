package Logic;
import DataAccess.DAOs.SupplierProductsDAO;
import DataAccess.DTOs.SupplierProductsDTO;

public class SupplierProducts {
    private SupplierProductsDAO supplierproductsDAO;
    private String cn;
    private String productName;
    private double price;
    private String catalogNum;
    
    public SupplierProducts(String cn, String productName, double price, String catalogNum) {
        this.cn = cn;
        this.productName = productName;
        this.price = price;
        this.catalogNum = catalogNum;
        this.supplierproductsDAO = new SupplierProductsDAO();
    }
    public String getCn() {
        return this.cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierproductsDAO.update(this);
    }
    public String getProductName() {
        return this.productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
        this.supplierproductsDAO.update(this);
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
        this.supplierproductsDAO.update(this);
    }
    public String getCatalogNum() {
        return this.catalogNum;
    }
    public void setCatalogNum(String catalogNum) {
        this.catalogNum = catalogNum;
        this.supplierproductsDAO.update(this);
    }
    @Override
    public String toString(){
        return "SupplierProducts{" +
        "cn = [" + this.cn + "], " +
        "productName = [" + this.productName + "], " +
        "price = [" + this.price + "], " +
        "catalogNum = [" + this.catalogNum + "], " +
        "}";
    }
    
}
