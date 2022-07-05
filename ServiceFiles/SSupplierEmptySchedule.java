package Service.Objects;

public class SSupplierEmptySchedule {
    private String cn;
    public SSupplierEmptySchedule(String cn) {
        
        this.cn = cn;
    }
    
    public SSupplierEmptySchedule(SupplierEmptySchedule business) {
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
        return "SupplierEmptySchedule{cn = [" + this.cn"],  " +
        "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SSupplierEmptySchedule)) return false;
        SSupplierEmptySchedule that = (SSupplierEmptySchedule) o;
        return Object.equals(getCn(), (that.getCn()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn());
    }
}
