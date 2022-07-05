package Logic;
import DataAccess.DAOs.ProductsDAO;
import DataAccess.DTOs.ProductsDTO;

public class Products {
    private ProductsDAO productsDAO;
    private long ID;
    private String name;
    private String manufacturer;
    private double price;
    private long category_ID;
    private long demand_per_day;
    private long item_id_runner;
    
    public Products(long ID, String name, String manufacturer, double price, long category_ID, long demand_per_day, long item_id_runner) {
        this.ID = ID;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.category_ID = category_ID;
        this.demand_per_day = demand_per_day;
        this.item_id_runner = item_id_runner;
        this.productsDAO = new ProductsDAO();
    }
    public long getID() {
        return this.ID;
    }
    public void setID(long ID) {
        this.ID = ID;
        this.productsDAO.update(this);
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
        this.productsDAO.update(this);
    }
    public String getManufacturer() {
        return this.manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        this.productsDAO.update(this);
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
        this.productsDAO.update(this);
    }
    public long getCategory_ID() {
        return this.category_ID;
    }
    public void setCategory_ID(long category_ID) {
        this.category_ID = category_ID;
        this.productsDAO.update(this);
    }
    public long getDemand_per_day() {
        return this.demand_per_day;
    }
    public void setDemand_per_day(long demand_per_day) {
        this.demand_per_day = demand_per_day;
        this.productsDAO.update(this);
    }
    public long getItem_id_runner() {
        return this.item_id_runner;
    }
    public void setItem_id_runner(long item_id_runner) {
        this.item_id_runner = item_id_runner;
        this.productsDAO.update(this);
    }
    @Override
    public String toString(){
        return "Products{" +
        "ID = [" + this.ID + "], " +
        "name = [" + this.name + "], " +
        "manufacturer = [" + this.manufacturer + "], " +
        "price = [" + this.price + "], " +
        "category_ID = [" + this.category_ID + "], " +
        "demand_per_day = [" + this.demand_per_day + "], " +
        "item_id_runner = [" + this.item_id_runner + "], " +
        "}";
    }
    
}
