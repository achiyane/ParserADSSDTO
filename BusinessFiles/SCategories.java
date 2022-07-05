package Logic;
import DataAccess.DAOs.CategoriesDAO;
import DataAccess.DTOs.CategoriesDTO;

public class Categories {
    private CategoriesDAO categoriesDAO;
    private long ID;
    private long parent_ID;
    private String name;
    
    public Categories(long ID, long parent_ID, String name) {
        this.ID = ID;
        this.parent_ID = parent_ID;
        this.name = name;
        this.categoriesDAO = new CategoriesDAO();
    }
    public long getID() {
        return this.ID;
    }
    public void setID(long ID) {
        this.ID = ID;
        this.categoriesDAO.update(this);
    }
    public long getParent_ID() {
        return this.parent_ID;
    }
    public void setParent_ID(long parent_ID) {
        this.parent_ID = parent_ID;
        this.categoriesDAO.update(this);
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
        this.categoriesDAO.update(this);
    }
    @Override
    public String toString(){
        return "Categories{" +
        "ID = [" + this.ID + "], " +
        "parent_ID = [" + this.parent_ID + "], " +
        "name = [" + this.name + "], " +
        "}";
    }
    
}
