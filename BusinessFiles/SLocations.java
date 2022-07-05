package Logic;
import DataAccess.DAOs.LocationsDAO;
import DataAccess.DTOs.LocationsDTO;

public class Locations {
    private LocationsDAO locationsDAO;
    private long item_ID;
    private long product_ID;
    private String branch;
    private String place;
    private long shelf;
    
    public Locations(long item_ID, long product_ID, String branch, String place, long shelf) {
        this.item_ID = item_ID;
        this.product_ID = product_ID;
        this.branch = branch;
        this.place = place;
        this.shelf = shelf;
        this.locationsDAO = new LocationsDAO();
    }
    public long getItem_ID() {
        return this.item_ID;
    }
    public void setItem_ID(long item_ID) {
        this.item_ID = item_ID;
        this.locationsDAO.update(this);
    }
    public long getProduct_ID() {
        return this.product_ID;
    }
    public void setProduct_ID(long product_ID) {
        this.product_ID = product_ID;
        this.locationsDAO.update(this);
    }
    public String getBranch() {
        return this.branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
        this.locationsDAO.update(this);
    }
    public String getPlace() {
        return this.place;
    }
    public void setPlace(String place) {
        this.place = place;
        this.locationsDAO.update(this);
    }
    public long getShelf() {
        return this.shelf;
    }
    public void setShelf(long shelf) {
        this.shelf = shelf;
        this.locationsDAO.update(this);
    }
    @Override
    public String toString(){
        return "Locations{" +
        "item_ID = [" + this.item_ID + "], " +
        "product_ID = [" + this.product_ID + "], " +
        "branch = [" + this.branch + "], " +
        "place = [" + this.place + "], " +
        "shelf = [" + this.shelf + "], " +
        "}";
    }
    
}
