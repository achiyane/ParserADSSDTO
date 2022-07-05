package Logic;
import DataAccess.DAOs.PurchasesDAO;
import DataAccess.DTOs.PurchasesDTO;

public class Purchases {
    private PurchasesDAO purchasesDAO;
    private long product_ID;
    private double cost_price;
    private double sale_price;
    private double discount;
    private long quantity;
    private String supplier;
    private String purchase_time;
    
    public Purchases(long product_ID, double cost_price, double sale_price, double discount, long quantity, String supplier, String purchase_time) {
        this.product_ID = product_ID;
        this.cost_price = cost_price;
        this.sale_price = sale_price;
        this.discount = discount;
        this.quantity = quantity;
        this.supplier = supplier;
        this.purchase_time = purchase_time;
        this.purchasesDAO = new PurchasesDAO();
    }
    public long getProduct_ID() {
        return this.product_ID;
    }
    public void setProduct_ID(long product_ID) {
        this.product_ID = product_ID;
        this.purchasesDAO.update(this);
    }
    public double getCost_price() {
        return this.cost_price;
    }
    public void setCost_price(double cost_price) {
        this.cost_price = cost_price;
        this.purchasesDAO.update(this);
    }
    public double getSale_price() {
        return this.sale_price;
    }
    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
        this.purchasesDAO.update(this);
    }
    public double getDiscount() {
        return this.discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
        this.purchasesDAO.update(this);
    }
    public long getQuantity() {
        return this.quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
        this.purchasesDAO.update(this);
    }
    public String getSupplier() {
        return this.supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
        this.purchasesDAO.update(this);
    }
    public String getPurchase_time() {
        return this.purchase_time;
    }
    public void setPurchase_time(String purchase_time) {
        this.purchase_time = purchase_time;
        this.purchasesDAO.update(this);
    }
    @Override
    public String toString(){
        return "Purchases{" +
        "product_ID = [" + this.product_ID + "], " +
        "cost_price = [" + this.cost_price + "], " +
        "sale_price = [" + this.sale_price + "], " +
        "discount = [" + this.discount + "], " +
        "quantity = [" + this.quantity + "], " +
        "supplier = [" + this.supplier + "], " +
        "purchase_time = [" + this.purchase_time + "], " +
        "}";
    }
    
}
