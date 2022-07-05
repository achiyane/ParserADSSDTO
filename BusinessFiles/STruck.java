package Logic;
import DataAccess.DAOs.TruckDAO;
import DataAccess.DTOs.TruckDTO;

public class Truck {
    private TruckDAO truckDAO;
    private long truckId;
    private String model;
    private long basicWeight;
    private long maxWeight;
    private String license;
    
    public Truck(long truckId, String model, long basicWeight, long maxWeight, String license) {
        this.truckId = truckId;
        this.model = model;
        this.basicWeight = basicWeight;
        this.maxWeight = maxWeight;
        this.license = license;
        this.truckDAO = new TruckDAO();
    }
    public long getTruckId() {
        return this.truckId;
    }
    public void setTruckId(long truckId) {
        this.truckId = truckId;
        this.truckDAO.update(this);
    }
    public String getModel() {
        return this.model;
    }
    public void setModel(String model) {
        this.model = model;
        this.truckDAO.update(this);
    }
    public long getBasicWeight() {
        return this.basicWeight;
    }
    public void setBasicWeight(long basicWeight) {
        this.basicWeight = basicWeight;
        this.truckDAO.update(this);
    }
    public long getMaxWeight() {
        return this.maxWeight;
    }
    public void setMaxWeight(long maxWeight) {
        this.maxWeight = maxWeight;
        this.truckDAO.update(this);
    }
    public String getLicense() {
        return this.license;
    }
    public void setLicense(String license) {
        this.license = license;
        this.truckDAO.update(this);
    }
    @Override
    public String toString(){
        return "Truck{" +
        "truckId = [" + this.truckId + "], " +
        "model = [" + this.model + "], " +
        "basicWeight = [" + this.basicWeight + "], " +
        "maxWeight = [" + this.maxWeight + "], " +
        "license = [" + this.license + "], " +
        "}";
    }
    
}
