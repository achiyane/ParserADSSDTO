package Service.Objects;

public class SSupplierProducts {
    private String cn;
    private String productName;
    private double price;
    private String catalogNum;
    public SSupplierProducts(String cn, String productName, double price, String catalogNum) {
        
        this.cn = cn;
        this.productName = productName;
        this.price = price;
        this.catalogNum = catalogNum;
    }
    
    public SSupplierProducts(SupplierProducts business) {
        this.cn = business.getCn();
        this.productName = business.getProductName();
        this.price = business.getPrice();
        this.catalogNum = business.getCatalogNum();
    }
    
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCatalogNum() {
        return catalogNum;
    }
    public void setCatalogNum(String catalogNum) {
        this.catalogNum = catalogNum;
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
        if (!(o instanceof SSupplierProducts)) return false;
        SSupplierProducts that = (SSupplierProducts) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getProductName(), (that.getProductName())) && Object.equals(getPrice(), (that.getPrice())) && Object.equals(getCatalogNum(), (that.getCatalogNum()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getProductName(), getPrice(), getCatalogNum());
    }
}
