package fasttrack.model;

public class Driver {
    private int id;
    private String name;
    private String vehicle;
    private boolean available;

    public Driver(int id, String name, String vehicle, boolean available) {
        this.id = id;
        this.name = name;
        this.vehicle = vehicle;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

