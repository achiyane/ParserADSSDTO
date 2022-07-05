package Logic;
import DataAccess.DAOs.DiscountsDAO;
import DataAccess.DTOs.DiscountsDTO;

public class Discounts {
    private DiscountsDAO discountsDAO;
    private String ID;
    private long category_ID;
    private long product_ID;
    private double discount;
    private String date_from;
    private String date_to;
    
    public Discounts(String ID, long category_ID, long product_ID, double discount, String date_from, String date_to) {
        this.ID = ID;
        this.category_ID = category_ID;
        this.product_ID = product_ID;
        this.discount = discount;
        this.date_from = date_from;
        this.date_to = date_to;
        this.discountsDAO = new DiscountsDAO();
    }
    public String getID() {
        return this.ID;
    }
    public void setID(String ID) {
        this.ID = ID;
        this.discountsDAO.update(this);
    }
    public long getCategory_ID() {
        return this.category_ID;
    }
    public void setCategory_ID(long category_ID) {
        this.category_ID = category_ID;
        this.discountsDAO.update(this);
    }
    public long getProduct_ID() {
        return this.product_ID;
    }
    public void setProduct_ID(long product_ID) {
        this.product_ID = product_ID;
        this.discountsDAO.update(this);
    }
    public double getDiscount() {
        return this.discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
        this.discountsDAO.update(this);
    }
    public String getDate_from() {
        return this.date_from;
    }
    public void setDate_from(String date_from) {
        this.date_from = date_from;
        this.discountsDAO.update(this);
    }
    public String getDate_to() {
        return this.date_to;
    }
    public void setDate_to(String date_to) {
        this.date_to = date_to;
        this.discountsDAO.update(this);
    }
    @Override
    public String toString(){
        return "Discounts{" +
        "ID = [" + this.ID + "], " +
        "category_ID = [" + this.category_ID + "], " +
        "product_ID = [" + this.product_ID + "], " +
        "discount = [" + this.discount + "], " +
        "date_from = [" + this.date_from + "], " +
        "date_to = [" + this.date_to + "], " +
        "}";
    }
    
}
