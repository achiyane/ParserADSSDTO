package Logic;
import DataAccess.DAOs.ItemsDAO;
import DataAccess.DTOs.ItemsDTO;

public class Items {
    private int ID;
    private int product_ID;
    private String is_flaw;
    private String expired;
    private ItemsDAO itemsDAO;
    public Items(int ID, int product_ID, String is_flaw, String expired) {
        
        this.ID = ID;
        this.product_ID = product_ID;
        this.is_flaw = is_flaw;
        this.expired = expired;
        this.itemsDAO = new ItemsDAO();
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
        this.itemsDAO.update(this);
    }
    public int getProduct_ID() {
        return product_ID;
    }
    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
        this.itemsDAO.update(this);
    }
    public String getIs_flaw() {
        return is_flaw;
    }
    public void setIs_flaw(String is_flaw) {
        this.is_flaw = is_flaw;
        this.itemsDAO.update(this);
    }
    public String getExpired() {
        return expired;
    }
    public void setExpired(String expired) {
        this.expired = expired;
        this.itemsDAO.update(this);
    }
    @Override
    public String toString() {
        return "Items{ID = [" + this.ID"], " +
        "product_ID = [" + this.product_ID"], " +
        "is_flaw = [" + this.is_flaw"], " +
        "expired = [" + this.expired"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Items)) return false;
        Items that = (Items) o;
        return Object.equals(getID(), (that.getID())) && Object.equals(getProduct_ID(), (that.getProduct_ID())) && Object.equals(getIs_flaw(), (that.getIs_flaw())) && Object.equals(getExpired(), (that.getExpired()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getProduct_ID(), getIs_flaw(), getExpired());
    }
    
}
