package Logic;
import DataAccess.DAOs.BillOfQuantitiyDAO;
import DataAccess.DTOs.BillOfQuantitiyDTO;

public class BillOfQuantitiy {
    private String cn;
    private String productName;
    private double discount;
    private int startRange;
    private BillOfQuantitiyDAO billOfQuantitiyDAO;
    public BillOfQuantitiy(String cn, String productName, double discount, int startRange) {
        
        this.cn = cn;
        this.productName = productName;
        this.discount = discount;
        this.startRange = startRange;
        this.billOfQuantitiyDAO = new BillOfQuantitiyDAO();
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
        this.billOfQuantitiyDAO.update(this);
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
        this.billOfQuantitiyDAO.update(this);
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
        this.billOfQuantitiyDAO.update(this);
    }
    public int getStartRange() {
        return startRange;
    }
    public void setStartRange(int startRange) {
        this.startRange = startRange;
        this.billOfQuantitiyDAO.update(this);
    }
    @Override
    public String toString() {
        return "BillOfQuantitiy{cn = [" + this.cn"], " +
        "productName = [" + this.productName"], " +
        "discount = [" + this.discount"], " +
        "startRange = [" + this.startRange"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillOfQuantitiy)) return false;
        BillOfQuantitiy that = (BillOfQuantitiy) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getProductName(), (that.getProductName())) && Object.equals(getDiscount(), (that.getDiscount())) && Object.equals(getStartRange(), (that.getStartRange()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getProductName(), getDiscount(), getStartRange());
    }
    
}
