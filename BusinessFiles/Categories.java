package Logic;
import DataAccess.DAOs.CategoriesDAO;
import DataAccess.DTOs.CategoriesDTO;

public class Categories {
    private int ID;
    private int parent_ID;
    private String name;
    private CategoriesDAO categoriesDAO;
    public Categories(int ID, int parent_ID, String name) {
        
        this.ID = ID;
        this.parent_ID = parent_ID;
        this.name = name;
        this.categoriesDAO = new CategoriesDAO();
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
        this.categoriesDAO.update(this);
    }
    public int getParent_ID() {
        return parent_ID;
    }
    public void setParent_ID(int parent_ID) {
        this.parent_ID = parent_ID;
        this.categoriesDAO.update(this);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        this.categoriesDAO.update(this);
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
        if (!(o instanceof Categories)) return false;
        Categories that = (Categories) o;
        return Object.equals(getID(), (that.getID())) && Object.equals(getParent_ID(), (that.getParent_ID())) && Object.equals(getName(), (that.getName()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getParent_ID(), getName());
    }
    
}
