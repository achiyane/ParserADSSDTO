package Service.Objects;

public class SSupplier {
    private String cn;
    public SSupplier(String cn) {
        
        this.cn = cn;
    }
    
    public SSupplier(Supplier business) {
        this.cn = business.getCn();
    }
    
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    
    @Override
    public String toString() {
        return "Supplier{cn = [" + this.cn"],  " +
        "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SSupplier)) return false;
        SSupplier that = (SSupplier) o;
        return Object.equals(getCn(), (that.getCn()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn());
    }
}
