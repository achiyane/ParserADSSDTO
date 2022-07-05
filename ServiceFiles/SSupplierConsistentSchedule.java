package Service.Objects;

public class SSupplierConsistentSchedule {
    private String cn;
    private int day;
    public SSupplierConsistentSchedule(String cn, int day) {
        
        this.cn = cn;
        this.day = day;
    }
    
    public SSupplierConsistentSchedule(SupplierConsistentSchedule business) {
        this.cn = business.getCn();
        this.day = business.getDay();
    }
    
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    
    @Override
    public String toString() {
        return "SupplierConsistentSchedule{cn = [" + this.cn"], " +
        "day = [" + this.day"],  " +
        "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SSupplierConsistentSchedule)) return false;
        SSupplierConsistentSchedule that = (SSupplierConsistentSchedule) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getDay(), (that.getDay()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getDay());
    }
}
