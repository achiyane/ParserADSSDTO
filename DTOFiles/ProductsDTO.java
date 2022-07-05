package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class ProductsDTO extends DTO<PK> {
    private long ID;
    private String name;
    private String manufacturer;
    private double price;
    private long category_ID;
    private long demand_per_day;
    private long item_id_runner;
    
    public ProductsDTO(long ID, String name, String manufacturer, double price, long category_ID, long demand_per_day, long item_id_runner) {
        super(new PK(getFields(), ID));
        
        this.ID = ID;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.category_ID = category_ID;
        this.demand_per_day = demand_per_day;
        this.item_id_runner = item_id_runner;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"ID"}, ProductsDTO.class);
    }
    public static PK getPK(long ID) {
        return new PK(getFields(), ID);
    }
    public long getID() {
        return ID;
    }
    public void setID(long ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public long getCategory_ID() {
        return category_ID;
    }
    public void setCategory_ID(long category_ID) {
        this.category_ID = category_ID;
    }
    public long getDemand_per_day() {
        return demand_per_day;
    }
    public void setDemand_per_day(long demand_per_day) {
        this.demand_per_day = demand_per_day;
    }
    public long getItem_id_runner() {
        return item_id_runner;
    }
    public void setItem_id_runner(long item_id_runner) {
        this.item_id_runner = item_id_runner;
    }
    @Override
    public String toString() {
        return "Products{ID = [" + this.ID"], " +
        "name = [" + this.name"], " +
        "manufacturer = [" + this.manufacturer"], " +
        "price = [" + this.price"], " +
        "category_ID = [" + this.category_ID"], " +
        "demand_per_day = [" + this.demand_per_day"], " +
        "item_id_runner = [" + this.item_id_runner"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.ID, this.name, this.manufacturer, this.price, this.category_ID, this.demand_per_day, this.item_id_runner};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductsDTO)) return false;
        ProductsDTO that = (ProductsDTO) o;
        return Object.equals(getID(), (that.getID())) && Object.equals(getName(), (that.getName())) && Object.equals(getManufacturer(), (that.getManufacturer())) && Object.equals(getPrice(), (that.getPrice())) && Object.equals(getCategory_ID(), (that.getCategory_ID())) && Object.equals(getDemand_per_day(), (that.getDemand_per_day())) && Object.equals(getItem_id_runner(), (that.getItem_id_runner()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getName(), getManufacturer(), getPrice(), getCategory_ID(), getDemand_per_day(), getItem_id_runner());
    }
}
