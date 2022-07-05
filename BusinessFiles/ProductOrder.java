package Logic;
import DataAccess.DAOs.ProductOrderDAO;
import DataAccess.DTOs.ProductOrderDTO;

public class ProductOrder {
    private int orderID;
    private String catalogNum;
    private String productName;
    private int quantity;
    private double totalPriceWithoutDiscount;
    private double discount;
    private double finalPrice;
    private ProductOrderDAO productOrderDAO;
    public ProductOrder(int orderID, String catalogNum, String productName, int quantity, double totalPriceWithoutDiscount, double discount, double finalPrice) {
        
        this.orderID = orderID;
        this.catalogNum = catalogNum;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.productOrderDAO = new ProductOrderDAO();
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
        this.productOrderDAO.update(this);
    }
    public String getCatalogNum() {
        return catalogNum;
    }
    public void setCatalogNum(String catalogNum) {
        this.catalogNum = catalogNum;
        this.productOrderDAO.update(this);
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
        this.productOrderDAO.update(this);
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.productOrderDAO.update(this);
    }
    public double getTotalPriceWithoutDiscount() {
        return totalPriceWithoutDiscount;
    }
    public void setTotalPriceWithoutDiscount(double totalPriceWithoutDiscount) {
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
        this.productOrderDAO.update(this);
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
        this.productOrderDAO.update(this);
    }
    public double getFinalPrice() {
        return finalPrice;
    }
    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
        this.productOrderDAO.update(this);
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductOrder)) return false;
        ProductOrder that = (ProductOrder) o;
        return Object.equals(getOrderID(), (that.getOrderID())) && Object.equals(getCatalogNum(), (that.getCatalogNum())) && Object.equals(getProductName(), (that.getProductName())) && Object.equals(getQuantity(), (that.getQuantity())) && Object.equals(getTotalPriceWithoutDiscount(), (that.getTotalPriceWithoutDiscount())) && Object.equals(getDiscount(), (that.getDiscount())) && Object.equals(getFinalPrice(), (that.getFinalPrice()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getOrderID(), getCatalogNum(), getProductName(), getQuantity(), getTotalPriceWithoutDiscount(), getDiscount(), getFinalPrice());
    }
    
}
