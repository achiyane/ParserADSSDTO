package Service.Objects;

public class SSupplierNotConsistentSchedule {
    private String cn;
    private int daysTillNextShipment;
    public SSupplierNotConsistentSchedule(String cn, int daysTillNextShipment) {
        
        this.cn = cn;
        this.daysTillNextShipment = daysTillNextShipment;
    }
    
    public SSupplierNotConsistentSchedule(SupplierNotConsistentSchedule business) {
        this.cn = business.getCn();
        this.daysTillNextShipment = business.getDaysTillNextShipment();
    }
    
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    public int getDaysTillNextShipment() {
        return daysTillNextShipment;
    }
    public void setDaysTillNextShipment(int daysTillNextShipment) {
        this.daysTillNextShipment = daysTillNextShipment;
    }
    
    @Override
    public String toString() {
        return "SupplierNotConsistentSchedule{cn = [" + this.cn"], " +
        "daysTillNextShipment = [" + this.daysTillNextShipment"],  " +
        "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SSupplierNotConsistentSchedule)) return false;
        SSupplierNotConsistentSchedule that = (SSupplierNotConsistentSchedule) o;
        return Object.equals(getCn(), (that.getCn())) && Object.equals(getDaysTillNextShipment(), (that.getDaysTillNextShipment()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCn(), getDaysTillNextShipment());
    }
}
