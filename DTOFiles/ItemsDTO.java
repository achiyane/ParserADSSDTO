package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class ItemsDTO extends DTO<PK> {
    private long ID;
    private long product_ID;
    private String is_flaw;
    private String expired;
    
    public ItemsDTO(long ID, long product_ID, String is_flaw, String expired) {
        super(new PK(getFields(), ID, product_ID));
        
        this.ID = ID;
        this.product_ID = product_ID;
        this.is_flaw = is_flaw;
        this.expired = expired;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"ID", "product_ID"}, ItemsDTO.class);
    }
    public static PK getPK(long ID, long product_ID) {
        return new PK(getFields(), ID, product_ID);
    }
    public long getID() {
        return ID;
    }
    public void setID(long ID) {
        this.ID = ID;
    }
    public long getProduct_ID() {
        return product_ID;
    }
    public void setProduct_ID(long product_ID) {
        this.product_ID = product_ID;
    }
    public String getIs_flaw() {
        return is_flaw;
    }
    public void setIs_flaw(String is_flaw) {
        this.is_flaw = is_flaw;
    }
    public String getExpired() {
        return expired;
    }
    public void setExpired(String expired) {
        this.expired = expired;
    }
    @Override
    public String toString() {
        return "Items{ID = [" + this.ID"], " +
        "product_ID = [" + this.product_ID"], " +
        "is_flaw = [" + this.is_flaw"], " +
        "expired = [" + this.expired"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.ID, this.product_ID, this.is_flaw, this.expired};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemsDTO)) return false;
        ItemsDTO that = (ItemsDTO) o;
        return Object.equals(getID(), (that.getID())) && Object.equals(getProduct_ID(), (that.getProduct_ID())) && Object.equals(getIs_flaw(), (that.getIs_flaw())) && Object.equals(getExpired(), (that.getExpired()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getProduct_ID(), getIs_flaw(), getExpired());
    }
}
