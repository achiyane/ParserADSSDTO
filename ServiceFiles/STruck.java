package Service.Objects;

public class STruck {
    private int truckId;
    private String model;
    private int basicWeight;
    private int maxWeight;
    private String license;
    public STruck(int truckId, String model, int basicWeight, int maxWeight, String license) {
        
        this.truckId = truckId;
        this.model = model;
        this.basicWeight = basicWeight;
        this.maxWeight = maxWeight;
        this.license = license;
    }
    
    public STruck(Truck business) {
        this.truckId = business.getTruckId();
        this.model = business.getModel();
        this.basicWeight = business.getBasicWeight();
        this.maxWeight = business.getMaxWeight();
        this.license = business.getLicense();
    }
    
    public int getTruckId() {
        return truckId;
    }
    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getBasicWeight() {
        return basicWeight;
    }
    public void setBasicWeight(int basicWeight) {
        this.basicWeight = basicWeight;
    }
    public int getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
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
        if (!(o instanceof STruck)) return false;
        STruck that = (STruck) o;
        return Object.equals(getTruckId(), (that.getTruckId())) && Object.equals(getModel(), (that.getModel())) && Object.equals(getBasicWeight(), (that.getBasicWeight())) && Object.equals(getMaxWeight(), (that.getMaxWeight())) && Object.equals(getLicense(), (that.getLicense()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getTruckId(), getModel(), getBasicWeight(), getMaxWeight(), getLicense());
    }
}
