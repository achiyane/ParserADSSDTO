package Logic;
import DataAccess.DAOs.TruckDAO;
import DataAccess.DTOs.TruckDTO;

public class Truck {
    private int truckId;
    private String model;
    private int basicWeight;
    private int maxWeight;
    private String license;
    private TruckDAO truckDAO;
    public Truck(int truckId, String model, int basicWeight, int maxWeight, String license) {
        
        this.truckId = truckId;
        this.model = model;
        this.basicWeight = basicWeight;
        this.maxWeight = maxWeight;
        this.license = license;
        this.truckDAO = new TruckDAO();
    }
    public int getTruckId() {
        return truckId;
    }
    public void setTruckId(int truckId) {
        this.truckId = truckId;
        this.truckDAO.update(this);
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
        this.truckDAO.update(this);
    }
    public int getBasicWeight() {
        return basicWeight;
    }
    public void setBasicWeight(int basicWeight) {
        this.basicWeight = basicWeight;
        this.truckDAO.update(this);
    }
    public int getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
        this.truckDAO.update(this);
    }
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
        this.truckDAO.update(this);
    }
    @Override
    public String toString() {
        return "Truck{truckId = [" + this.truckId"], " +
        "model = [" + this.model"], " +
        "basicWeight = [" + this.basicWeight"], " +
        "maxWeight = [" + this.maxWeight"], " +
        "license = [" + this.license"],  " +
        "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        Truck that = (Truck) o;
        return Object.equals(getTruckId(), (that.getTruckId())) && Object.equals(getModel(), (that.getModel())) && Object.equals(getBasicWeight(), (that.getBasicWeight())) && Object.equals(getMaxWeight(), (that.getMaxWeight())) && Object.equals(getLicense(), (that.getLicense()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getTruckId(), getModel(), getBasicWeight(), getMaxWeight(), getLicense());
    }
    
}
