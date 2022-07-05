package Service.Objects;

public class SProducts {
    private int ID;
    private String name;
    private String manufacturer;
    private double price;
    private int category_ID;
    private int demand_per_day;
    private int item_id_runner;
    public SProducts(int ID, String name, String manufacturer, double price, int category_ID, int demand_per_day, int item_id_runner) {
        
        this.ID = ID;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.category_ID = category_ID;
        this.demand_per_day = demand_per_day;
        this.item_id_runner = item_id_runner;
    }
    
    public SProducts(Products business) {
        this.ID = business.getID();
        this.name = business.getName();
        this.manufacturer = business.getManufacturer();
        this.price = business.getPrice();
        this.category_ID = business.getCategory_ID();
        this.demand_per_day = business.getDemand_per_day();
        this.item_id_runner = business.getItem_id_runner();
    }
    
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
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
    public int getCategory_ID() {
        return category_ID;
    }
    public void setCategory_ID(int category_ID) {
        this.category_ID = category_ID;
    }
    public int getDemand_per_day() {
        return demand_per_day;
    }
    public void setDemand_per_day(int demand_per_day) {
        this.demand_per_day = demand_per_day;
    }
    public int getItem_id_runner() {
        return item_id_runner;
    }
    public void setItem_id_runner(int item_id_runner) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SProducts)) return false;
        SProducts that = (SProducts) o;
        return Object.equals(getID(), (that.getID())) && Object.equals(getName(), (that.getName())) && Object.equals(getManufacturer(), (that.getManufacturer())) && Object.equals(getPrice(), (that.getPrice())) && Object.equals(getCategory_ID(), (that.getCategory_ID())) && Object.equals(getDemand_per_day(), (that.getDemand_per_day())) && Object.equals(getItem_id_runner(), (that.getItem_id_runner()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getName(), getManufacturer(), getPrice(), getCategory_ID(), getDemand_per_day(), getItem_id_runner());
    }
}
