package Logic;
import DataAccess.DAOs.LocationsDAO;
import DataAccess.DTOs.LocationsDTO;

public class Locations {
    private int item_ID;
    private int product_ID;
    private String branch;
    private String place;
    private int shelf;
    private LocationsDAO locationsDAO;
    public Locations(int item_ID, int product_ID, String branch, String place, int shelf) {
        
        this.item_ID = item_ID;
        this.product_ID = product_ID;
        this.branch = branch;
        this.place = place;
        this.shelf = shelf;
        this.locationsDAO = new LocationsDAO();
    }
    public int getItem_ID() {
        return item_ID;
    }
    public void setItem_ID(int item_ID) {
        this.item_ID = item_ID;
        this.locationsDAO.update(this);
    }
    public int getProduct_ID() {
        return product_ID;
    }
    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
        this.locationsDAO.update(this);
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
        this.locationsDAO.update(this);
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
        this.locationsDAO.update(this);
    }
    public int getShelf() {
        return shelf;
    }
    public void setShelf(int shelf) {
        this.shelf = shelf;
        this.locationsDAO.update(this);
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locations)) return false;
        Locations that = (Locations) o;
        return Object.equals(getItem_ID(), (that.getItem_ID())) && Object.equals(getProduct_ID(), (that.getProduct_ID())) && Object.equals(getBranch(), (that.getBranch())) && Object.equals(getPlace(), (that.getPlace())) && Object.equals(getShelf(), (that.getShelf()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getItem_ID(), getProduct_ID(), getBranch(), getPlace(), getShelf());
    }
    
}
