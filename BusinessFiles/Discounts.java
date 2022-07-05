package Logic;
import DataAccess.DAOs.DiscountsDAO;
import DataAccess.DTOs.DiscountsDTO;

public class Discounts {
    private String ID;
    private int category_ID;
    private int product_ID;
    private double discount;
    private String date_from;
    private String date_to;
    private DiscountsDAO discountsDAO;
    public Discounts(String ID, int category_ID, int product_ID, double discount, String date_from, String date_to) {
        
        this.ID = ID;
        this.category_ID = category_ID;
        this.product_ID = product_ID;
        this.discount = discount;
        this.date_from = date_from;
        this.date_to = date_to;
        this.discountsDAO = new DiscountsDAO();
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
        this.discountsDAO.update(this);
    }
    public int getCategory_ID() {
        return category_ID;
    }
    public void setCategory_ID(int category_ID) {
        this.category_ID = category_ID;
        this.discountsDAO.update(this);
    }
    public int getProduct_ID() {
        return product_ID;
    }
    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
        this.discountsDAO.update(this);
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
        this.discountsDAO.update(this);
    }
    public String getDate_from() {
        return date_from;
    }
    public void setDate_from(String date_from) {
        this.date_from = date_from;
        this.discountsDAO.update(this);
    }
    public String getDate_to() {
        return date_to;
    }
    public void setDate_to(String date_to) {
        this.date_to = date_to;
        this.discountsDAO.update(this);
    }
    @Override
    public String toString() {
        return "Discounts{ID = [" + this.ID"], " +
        "category_ID = [" + this.category_ID"], " +
        "product_ID = [" + this.product_ID"], " +
        "discount = [" + this.discount"], " +
        "date_from = [" + this.date_from"], " +
        "date_to = [" + this.date_to"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discounts)) return false;
        Discounts that = (Discounts) o;
        return Object.equals(getID(), (that.getID())) && Object.equals(getCategory_ID(), (that.getCategory_ID())) && Object.equals(getProduct_ID(), (that.getProduct_ID())) && Object.equals(getDiscount(), (that.getDiscount())) && Object.equals(getDate_from(), (that.getDate_from())) && Object.equals(getDate_to(), (that.getDate_to()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getCategory_ID(), getProduct_ID(), getDiscount(), getDate_from(), getDate_to());
    }
    
}
