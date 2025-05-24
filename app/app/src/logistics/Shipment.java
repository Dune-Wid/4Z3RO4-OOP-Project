package logistics;

public class Shipment {
    private String shipmentId;
    private String packageType;
    private Driver assignedDriver;

    public Shipment(String shipmentId, String packageType) {
        this.shipmentId = shipmentId;
        this.packageType = packageType;
    }

    public String getShipmentId() { return shipmentId; }
    public String getPackageType() { return packageType; }
    public Driver getAssignedDriver() { return assignedDriver; }
    public void setAssignedDriver(Driver assignedDriver) { this.assignedDriver = assignedDriver; }

    @Override
    public String toString() {
        return "Shipment " + shipmentId + " (" + packageType + ")";
    }
}

