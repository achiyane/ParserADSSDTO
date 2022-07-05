package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class SupplierProductsDTO extends DTO<PK> {
    private String cn;
    private String productName;
    private double price;
    private String catalogNum;
    
    public SupplierProductsDTO(String cn, String productName, double price, String catalogNum) {
        super(new PK(getFields(), cn, productName));
        
        this.cn = cn;
        this.productName = productName;
        this.price = price;
        this.catalogNum = catalogNum;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"cn", "productName"}, SupplierProductsDTO.class);
    }
    public static PK getPK(String cn, String productName) {
        return new PK(getFields(), cn, productName);
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
    public Object[] getValues(){
        return new Object[]{this.cn, this.productName, this.price, this.catalogNum};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierProductsDTO)) return false;
        SupplierProductsDTO that = (SupplierProductsDTO) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getProductName(), (that.getProductName())) && Object.equals(getPrice(), (that.getPrice())) && Object.equals(getCatalogNum(), (that.getCatalogNum()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getProductName(), getPrice(), getCatalogNum());
    }
}
