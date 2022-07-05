package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class CategoriesDTO extends DTO<PK> {
    private long ID;
    private long parent_ID;
    private String name;
    
    public CategoriesDTO(long ID, long parent_ID, String name) {
        super(new PK(getFields(), ID));
        
        this.ID = ID;
        this.parent_ID = parent_ID;
        this.name = name;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"ID"}, CategoriesDTO.class);
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
    public long getParent_ID() {
        return parent_ID;
    }
    public void setParent_ID(long parent_ID) {
        this.parent_ID = parent_ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Categories{ID = [" + this.ID"], " +
        "parent_ID = [" + this.parent_ID"], " +
        "name = [" + this.name"],  " +
        "}";
    }
    public Object[] getValues(){
        return new Object[]{this.ID, this.parent_ID, this.name};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriesDTO)) return false;
        CategoriesDTO that = (CategoriesDTO) o;
        return Object.equals(getID(), (that.getID())) && Object.equals(getParent_ID(), (that.getParent_ID())) && Object.equals(getName(), (that.getName()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getParent_ID(), getName());
    }
}
