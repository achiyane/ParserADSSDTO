package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class DiscountsDTO extends DTO<PK> {
    private String ID;
    private long category_ID;
    private long product_ID;
    private double discount;
    private String date_from;
    private String date_to;
    
    public DiscountsDTO(String ID, long category_ID, long product_ID, double discount, String date_from, String date_to) {
        super(new PK(getFields(), ID));
        
        this.ID = ID;
        this.category_ID = category_ID;
        this.product_ID = product_ID;
        this.discount = discount;
        this.date_from = date_from;
        this.date_to = date_to;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"ID"}, DiscountsDTO.class);
    }
    public static PK getPK(String ID) {
        return new PK(getFields(), ID);
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public long getCategory_ID() {
        return category_ID;
    }
    public void setCategory_ID(long category_ID) {
        this.category_ID = category_ID;
    }
    public long getProduct_ID() {
        return product_ID;
    }
    public void setProduct_ID(long product_ID) {
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
    public Object[] getValues(){
        return new Object[]{this.ID, this.category_ID, this.product_ID, this.discount, this.date_from, this.date_to};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountsDTO)) return false;
        DiscountsDTO that = (DiscountsDTO) o;
        return Object.equals(getID(), (that.getID())) && Object.equals(getCategory_ID(), (that.getCategory_ID())) && Object.equals(getProduct_ID(), (that.getProduct_ID())) && Object.equals(getDiscount(), (that.getDiscount())) && Object.equals(getDate_from(), (that.getDate_from())) && Object.equals(getDate_to(), (that.getDate_to()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getCategory_ID(), getProduct_ID(), getDiscount(), getDate_from(), getDate_to());
    }
}
