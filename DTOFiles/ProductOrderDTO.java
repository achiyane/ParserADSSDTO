package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class ProductOrderDTO extends DTO<PK> {
    private long orderID;
    private String catalogNum;
    private String productName;
    private long quantity;
    private double totalPriceWithoutDiscount;
    private double discount;
    private double finalPrice;
    
    public ProductOrderDTO(long orderID, String catalogNum, String productName, long quantity, double totalPriceWithoutDiscount, double discount, double finalPrice) {
        super(new PK(getFields(), orderID, productName));
        
        this.orderID = orderID;
        this.catalogNum = catalogNum;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
        this.discount = discount;
        this.finalPrice = finalPrice;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"orderID", "productName"}, ProductOrderDTO.class);
    }
    public static PK getPK(long orderID, String productName) {
        return new PK(getFields(), orderID, productName);
    }
    public long getOrderID() {
        return orderID;
    }
    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }
    public String getCatalogNum() {
        return catalogNum;
    }
    public void setCatalogNum(String catalogNum) {
        this.catalogNum = catalogNum;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public double getTotalPriceWithoutDiscount() {
        return totalPriceWithoutDiscount;
    }
    public void setTotalPriceWithoutDiscount(double totalPriceWithoutDiscount) {
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public double getFinalPrice() {
        return finalPrice;
    }
    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
    @Override
    public String toString() {
        return "ProductOrder{orderID = [" + this.orderID"], " +
        "catalogNum = [" + this.catalogNum"], " +
        "productName = [" + this.productName"], " +
        "quantity = [" + this.quantity"], " +
        "totalPriceWithoutDiscount = [" + this.totalPriceWithoutDiscount"], " +
        "discount = [" + this.discount"], " +
        "finalPrice = [" + this.finalPrice"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.orderID, this.catalogNum, this.productName, this.quantity, this.totalPriceWithoutDiscount, this.discount, this.finalPrice};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductOrderDTO)) return false;
        ProductOrderDTO that = (ProductOrderDTO) o;
        return Object.equals(getOrderID(), (that.getOrderID())) && Object.equals(getCatalogNum(), (that.getCatalogNum())) && Object.equals(getProductName(), (that.getProductName())) && Object.equals(getQuantity(), (that.getQuantity())) && Object.equals(getTotalPriceWithoutDiscount(), (that.getTotalPriceWithoutDiscount())) && Object.equals(getDiscount(), (that.getDiscount())) && Object.equals(getFinalPrice(), (that.getFinalPrice()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getOrderID(), getCatalogNum(), getProductName(), getQuantity(), getTotalPriceWithoutDiscount(), getDiscount(), getFinalPrice());
    }
}
