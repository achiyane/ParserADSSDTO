package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;

public class TruckDTO extends DTO<PK> {
    private long truckId;
    private String model;
    private long basicWeight;
    private long maxWeight;
    private String license;
    
    public TruckDTO(long truckId, String model, long basicWeight, long maxWeight, String license) {
        super(new PK(getFields(), truckId));
        
        this.truckId = truckId;
        this.model = model;
        this.basicWeight = basicWeight;
        this.maxWeight = maxWeight;
        this.license = license;
    }
    public static Field[] getFields(){
        return getFields(new String[]{"truckId"}, TruckDTO.class);
    }
    public static PK getPK(long truckId) {
        return new PK(getFields(), truckId);
    }
    public long getTruckId() {
        return truckId;
    }
    public void setTruckId(long truckId) {
        this.truckId = truckId;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public long getBasicWeight() {
        return basicWeight;
    }
    public void setBasicWeight(long basicWeight) {
        this.basicWeight = basicWeight;
    }
    public long getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(long maxWeight) {
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
    public Object[] getValues(){
        return new Object[]{this.truckId, this.model, this.basicWeight, this.maxWeight, this.license};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TruckDTO)) return false;
        TruckDTO that = (TruckDTO) o;
        return Object.equals(getTruckId(), (that.getTruckId())) && Object.equals(getModel(), (that.getModel())) && Object.equals(getBasicWeight(), (that.getBasicWeight())) && Object.equals(getMaxWeight(), (that.getMaxWeight())) && Object.equals(getLicense(), (that.getLicense()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getTruckId(), getModel(), getBasicWeight(), getMaxWeight(), getLicense());
    }
}
