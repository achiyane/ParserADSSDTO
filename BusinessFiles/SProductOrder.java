package Logic;
import DataAccess.DAOs.ProductOrderDAO;
import DataAccess.DTOs.ProductOrderDTO;

public class ProductOrder {
    private ProductOrderDAO productorderDAO;
    private long orderID;
    private String catalogNum;
    private String productName;
    private long quantity;
    private double totalPriceWithoutDiscount;
    private double discount;
    private double finalPrice;
    
    public ProductOrder(long orderID, String catalogNum, String productName, long quantity, double totalPriceWithoutDiscount, double discount, double finalPrice) {
        this.orderID = orderID;
        this.catalogNum = catalogNum;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.productorderDAO = new ProductOrderDAO();
    }
    public long getOrderID() {
        return this.orderID;
    }
    public void setOrderID(long orderID) {
        this.orderID = orderID;
        this.productorderDAO.update(this);
    }
    public String getCatalogNum() {
        return this.catalogNum;
    }
    public void setCatalogNum(String catalogNum) {
        this.catalogNum = catalogNum;
        this.productorderDAO.update(this);
    }
    public String getProductName() {
        return this.productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
        this.productorderDAO.update(this);
    }
    public long getQuantity() {
        return this.quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
        this.productorderDAO.update(this);
    }
    public double getTotalPriceWithoutDiscount() {
        return this.totalPriceWithoutDiscount;
    }
    public void setTotalPriceWithoutDiscount(double totalPriceWithoutDiscount) {
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
        this.productorderDAO.update(this);
    }
    public double getDiscount() {
        return this.discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
        this.productorderDAO.update(this);
    }
    public double getFinalPrice() {
        return this.finalPrice;
    }
    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
        this.productorderDAO.update(this);
    }
    @Override
    public String toString(){
        return "ProductOrder{" +
        "orderID = [" + this.orderID + "], " +
        "catalogNum = [" + this.catalogNum + "], " +
        "productName = [" + this.productName + "], " +
        "quantity = [" + this.quantity + "], " +
        "totalPriceWithoutDiscount = [" + this.totalPriceWithoutDiscount + "], " +
        "discount = [" + this.discount + "], " +
        "finalPrice = [" + this.finalPrice + "], " +
        "}";
    }
    
}
