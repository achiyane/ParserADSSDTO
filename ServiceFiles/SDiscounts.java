package Service.Objects;

public class SDiscounts {
    private String ID;
    private int category_ID;
    private int product_ID;
    private double discount;
    private String date_from;
    private String date_to;
    public SDiscounts(String ID, int category_ID, int product_ID, double discount, String date_from, String date_to) {
        
        this.ID = ID;
        this.category_ID = category_ID;
        this.product_ID = product_ID;
        this.discount = discount;
        this.date_from = date_from;
        this.date_to = date_to;
    }
    
    public SDiscounts(Discounts business) {
        this.ID = business.getID();
        this.category_ID = business.getCategory_ID();
        this.product_ID = business.getProduct_ID();
        this.discount = business.getDiscount();
        this.date_from = business.getDate_from();
        this.date_to = business.getDate_to();
    }
    
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public int getCategory_ID() {
        return category_ID;
    }
    public void setCategory_ID(int category_ID) {
        this.category_ID = category_ID;
    }
    public int getProduct_ID() {
        return product_ID;
    }
    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public String getDate_from() {
        return date_from;
    }
    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }
    public String getDate_to() {
        return date_to;
    }
    public void setDate_to(String date_to) {
        this.date_to = date_to;
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
        if (!(o instanceof SDiscounts)) return false;
        SDiscounts that = (SDiscounts) o;
        return Object.equals(getID(), (that.getID())) && Object.equals(getCategory_ID(), (that.getCategory_ID())) && Object.equals(getProduct_ID(), (that.getProduct_ID())) && Object.equals(getDiscount(), (that.getDiscount())) && Object.equals(getDate_from(), (that.getDate_from())) && Object.equals(getDate_to(), (that.getDate_to()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getCategory_ID(), getProduct_ID(), getDiscount(), getDate_from(), getDate_to());
    }
}
