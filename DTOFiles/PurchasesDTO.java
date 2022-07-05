package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class PurchasesDTO extends DTO<PK> {
    private long product_ID;
    private double cost_price;
    private double sale_price;
    private double discount;
    private long quantity;
    private String supplier;
    private String purchase_time;
    
    public PurchasesDTO(long product_ID, double cost_price, double sale_price, double discount, long quantity, String supplier, String purchase_time) {
        super(new PK(getFields(), purchase_time, product_ID));
        
        this.product_ID = product_ID;
        this.cost_price = cost_price;
        this.sale_price = sale_price;
        this.discount = discount;
        this.quantity = quantity;
        this.supplier = supplier;
        this.purchase_time = purchase_time;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"purchase_time", "product_ID"}, PurchasesDTO.class);
    }
    public static PK getPK(String purchase_time, long product_ID) {
        return new PK(getFields(), purchase_time, product_ID);
    }
    public long getProduct_ID() {
        return product_ID;
    }
    public void setProduct_ID(long product_ID) {
        this.product_ID = product_ID;
    }
    public double getCost_price() {
        return cost_price;
    }
    public void setCost_price(double cost_price) {
        this.cost_price = cost_price;
    }
    public double getSale_price() {
        return sale_price;
    }
    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public String getPurchase_time() {
        return purchase_time;
    }
    public void setPurchase_time(String purchase_time) {
        this.purchase_time = purchase_time;
    }
    @Override
    public String toString() {
        return "Purchases{product_ID = [" + this.product_ID"], " +
        "cost_price = [" + this.cost_price"], " +
        "sale_price = [" + this.sale_price"], " +
        "discount = [" + this.discount"], " +
        "quantity = [" + this.quantity"], " +
        "supplier = [" + this.supplier"], " +
        "purchase_time = [" + this.purchase_time"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.product_ID, this.cost_price, this.sale_price, this.discount, this.quantity, this.supplier, this.purchase_time};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchasesDTO)) return false;
        PurchasesDTO that = (PurchasesDTO) o;
        return Object.equals(getProduct_ID(), (that.getProduct_ID())) && Object.equals(getCost_price(), (that.getCost_price())) && Object.equals(getSale_price(), (that.getSale_price())) && Object.equals(getDiscount(), (that.getDiscount())) && Object.equals(getQuantity(), (that.getQuantity())) && Object.equals(getSupplier(), (that.getSupplier())) && Object.equals(getPurchase_time(), (that.getPurchase_time()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getProduct_ID(), getCost_price(), getSale_price(), getDiscount(), getQuantity(), getSupplier(), getPurchase_time());
    }
}