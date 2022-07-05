package Service.Objects;

public class SCategories {
    private int ID;
    private int parent_ID;
    private String name;
    public SCategories(int ID, int parent_ID, String name) {
        
        this.ID = ID;
        this.parent_ID = parent_ID;
        this.name = name;
    }
    
    public SCategories(Categories business) {
        this.ID = business.getID();
        this.parent_ID = business.getParent_ID();
        this.name = business.getName();
    }
    
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getParent_ID() {
        return parent_ID;
    }
    public void setParent_ID(int parent_ID) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SCategories)) return false;
        SCategories that = (SCategories) o;
        return Object.equals(getID(), (that.getID())) && Object.equals(getParent_ID(), (that.getParent_ID())) && Object.equals(getName(), (that.getName()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getParent_ID(), getName());
    }
}
