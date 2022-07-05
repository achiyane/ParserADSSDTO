package Logic;
import DataAccess.DAOs.BillOfQuantitiyDAO;
import DataAccess.DTOs.BillOfQuantitiyDTO;

public class BillOfQuantitiy {
    private BillOfQuantitiyDAO billofquantitiyDAO;
    private String cn;
    private String productName;
    private double discount;
    private long startRange;
    
    public BillOfQuantitiy(String cn, String productName, double discount, long startRange) {
        this.cn = cn;
        this.productName = productName;
        this.discount = discount;
        this.startRange = startRange;
        this.billofquantitiyDAO = new BillOfQuantitiyDAO();
    }
    public String getCn() {
        return this.cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.billofquantitiyDAO.update(this);
    }
    public String getProductName() {
        return this.productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
        this.billofquantitiyDAO.update(this);
    }
    public double getDiscount() {
        return this.discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
        this.billofquantitiyDAO.update(this);
    }
    public long getStartRange() {
        return this.startRange;
    }
    public void setStartRange(long startRange) {
        this.startRange = startRange;
        this.billofquantitiyDAO.update(this);
    }
    @Override
    public String toString(){
        return "BillOfQuantitiy{" +
        "cn = [" + this.cn + "], " +
        "productName = [" + this.productName + "], " +
        "discount = [" + this.discount + "], " +
        "startRange = [" + this.startRange + "], " +
        "}";
    }
    
}
