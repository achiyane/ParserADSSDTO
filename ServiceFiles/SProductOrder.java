package Service.Objects;

public class SProductOrder {
    private int orderID;
    private String catalogNum;
    private String productName;
    private int quantity;
    private double totalPriceWithoutDiscount;
    private double discount;
    private double finalPrice;
    public SProductOrder(int orderID, String catalogNum, String productName, int quantity, double totalPriceWithoutDiscount, double discount, double finalPrice) {
        
        this.orderID = orderID;
        this.catalogNum = catalogNum;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
        this.discount = discount;
        this.finalPrice = finalPrice;
    }
    
    public SProductOrder(ProductOrder business) {
        this.orderID = business.getOrderID();
        this.catalogNum = business.getCatalogNum();
        this.productName = business.getProductName();
        this.quantity = business.getQuantity();
        this.totalPriceWithoutDiscount = business.getTotalPriceWithoutDiscount();
        this.discount = business.getDiscount();
        this.finalPrice = business.getFinalPrice();
    }
    
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SProductOrder)) return false;
        SProductOrder that = (SProductOrder) o;
        return Object.equals(getOrderID(), (that.getOrderID())) && Object.equals(getCatalogNum(), (that.getCatalogNum())) && Object.equals(getProductName(), (that.getProductName())) && Object.equals(getQuantity(), (that.getQuantity())) && Object.equals(getTotalPriceWithoutDiscount(), (that.getTotalPriceWithoutDiscount())) && Object.equals(getDiscount(), (that.getDiscount())) && Object.equals(getFinalPrice(), (that.getFinalPrice()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getOrderID(), getCatalogNum(), getProductName(), getQuantity(), getTotalPriceWithoutDiscount(), getDiscount(), getFinalPrice());
    }
}
