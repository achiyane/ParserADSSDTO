package Logic;
import DataAccess.DAOs.ItemsDAO;
import DataAccess.DTOs.ItemsDTO;

public class Items {
    private ItemsDAO itemsDAO;
    private long ID;
    private long product_ID;
    private String is_flaw;
    private String expired;
    
    public Items(long ID, long product_ID, String is_flaw, String expired) {
        this.ID = ID;
        this.product_ID = product_ID;
        this.is_flaw = is_flaw;
        this.expired = expired;
        this.itemsDAO = new ItemsDAO();
    }
    public long getID() {
        return this.ID;
    }
    public void setID(long ID) {
        this.ID = ID;
        this.itemsDAO.update(this);
    }
    public long getProduct_ID() {
        return this.product_ID;
    }
    public void setProduct_ID(long product_ID) {
        this.product_ID = product_ID;
        this.itemsDAO.update(this);
    }
    public String getIs_flaw() {
        return this.is_flaw;
    }
    public void setIs_flaw(String is_flaw) {
        this.is_flaw = is_flaw;
        this.itemsDAO.update(this);
    }
    public String getExpired() {
        return this.expired;
    }
    public void setExpired(String expired) {
        this.expired = expired;
        this.itemsDAO.update(this);
    }
    @Override
    public String toString(){
        return "Items{" +
        "ID = [" + this.ID + "], " +
        "product_ID = [" + this.product_ID + "], " +
        "is_flaw = [" + this.is_flaw + "], " +
        "expired = [" + this.expired + "], " +
        "}";
    }
    
}
