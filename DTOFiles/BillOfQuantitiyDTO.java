package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class BillOfQuantitiyDTO extends DTO<PK> {
    private String cn;
    private String productName;
    private double discount;
    private long startRange;
    
    public BillOfQuantitiyDTO(String cn, String productName, double discount, long startRange) {
        super(new PK(getFields(), cn, productName, startRange));
        
        this.cn = cn;
        this.productName = productName;
        this.discount = discount;
        this.startRange = startRange;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"cn", "productName", "startRange"}, BillOfQuantitiyDTO.class);
    }
    public static PK getPK(String cn, String productName, long startRange) {
        return new PK(getFields(), cn, productName, startRange);
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
    public long getStartRange() {
        return startRange;
    }
    public void setStartRange(long startRange) {
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
    public Object[] getValues(){
        return new Object[]{this.cn, this.productName, this.discount, this.startRange};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillOfQuantitiyDTO)) return false;
        BillOfQuantitiyDTO that = (BillOfQuantitiyDTO) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getProductName(), (that.getProductName())) && Object.equals(getDiscount(), (that.getDiscount())) && Object.equals(getStartRange(), (that.getStartRange()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getProductName(), getDiscount(), getStartRange());
    }
}
