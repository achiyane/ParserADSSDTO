package Logic;
import DataAccess.DAOs.SupplierProductsDAO;
import DataAccess.DTOs.SupplierProductsDTO;

public class SupplierProducts {
    private String cn;
    private String productName;
    private double price;
    private String catalogNum;
    private SupplierProductsDAO supplierProductsDAO;
    public SupplierProducts(String cn, String productName, double price, String catalogNum) {
        
        this.cn = cn;
        this.productName = productName;
        this.price = price;
        this.catalogNum = catalogNum;
        this.supplierProductsDAO = new SupplierProductsDAO();
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.supplierProductsDAO.update(this);
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
        this.supplierProductsDAO.update(this);
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
        this.supplierProductsDAO.update(this);
    }
    public String getCatalogNum() {
        return catalogNum;
    }
    public void setCatalogNum(String catalogNum) {
        this.catalogNum = catalogNum;
        this.supplierProductsDAO.update(this);
    }
    @Override
    public String toString() {
        return "SupplierProducts{cn = [" + this.cn"], " +
        "productName = [" + this.productName"], " +
        "price = [" + this.price"], " +
        "catalogNum = [" + this.catalogNum"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierProducts)) return false;
        SupplierProducts that = (SupplierProducts) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getProductName(), (that.getProductName())) && Object.equals(getPrice(), (that.getPrice())) && Object.equals(getCatalogNum(), (that.getCatalogNum()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getProductName(), getPrice(), getCatalogNum());
    }
    
}
