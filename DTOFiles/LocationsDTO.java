package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class LocationsDTO extends DTO<PK> {
    private long item_ID;
    private long product_ID;
    private String branch;
    private String place;
    private long shelf;
    
    public LocationsDTO(long item_ID, long product_ID, String branch, String place, long shelf) {
        super(new PK(getFields(), item_ID, product_ID));
        
        this.item_ID = item_ID;
        this.product_ID = product_ID;
        this.branch = branch;
        this.place = place;
        this.shelf = shelf;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"item_ID", "product_ID"}, LocationsDTO.class);
    }
    public static PK getPK(long item_ID, long product_ID) {
        return new PK(getFields(), item_ID, product_ID);
    }
    public long getItem_ID() {
        return item_ID;
    }
    public void setItem_ID(long item_ID) {
        this.item_ID = item_ID;
    }
    public long getProduct_ID() {
        return product_ID;
    }
    public void setProduct_ID(long product_ID) {
        this.product_ID = product_ID;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public long getShelf() {
        return shelf;
    }
    public void setShelf(long shelf) {
        this.shelf = shelf;
    }
    @Override
    public String toString() {
        return "Locations{item_ID = [" + this.item_ID"], " +
        "product_ID = [" + this.product_ID"], " +
        "branch = [" + this.branch"], " +
        "place = [" + this.place"], " +
        "shelf = [" + this.shelf"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.item_ID, this.product_ID, this.branch, this.place, this.shelf};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationsDTO)) return false;
        LocationsDTO that = (LocationsDTO) o;
        return Object.equals(getItem_ID(), (that.getItem_ID())) && Object.equals(getProduct_ID(), (that.getProduct_ID())) && Object.equals(getBranch(), (that.getBranch())) && Object.equals(getPlace(), (that.getPlace())) && Object.equals(getShelf(), (that.getShelf()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getItem_ID(), getProduct_ID(), getBranch(), getPlace(), getShelf());
    }
}
