package Service.Objects;

public class SBillOfQuantitiy {
    private String cn;
    private String productName;
    private double discount;
    private int startRange;
    public SBillOfQuantitiy(String cn, String productName, double discount, int startRange) {
        
        this.cn = cn;
        this.productName = productName;
        this.discount = discount;
        this.startRange = startRange;
    }
    
    public SBillOfQuantitiy(BillOfQuantitiy business) {
        this.cn = business.getCn();
        this.productName = business.getProductName();
        this.discount = business.getDiscount();
        this.startRange = business.getStartRange();
    }
    
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public int getStartRange() {
        return startRange;
    }
    public void setStartRange(int startRange) {
        this.startRange = startRange;
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
        if (!(o instanceof SBillOfQuantitiy)) return false;
        SBillOfQuantitiy that = (SBillOfQuantitiy) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getProductName(), (that.getProductName())) && Object.equals(getDiscount(), (that.getDiscount())) && Object.equals(getStartRange(), (that.getStartRange()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getProductName(), getDiscount(), getStartRange());
    }
}
