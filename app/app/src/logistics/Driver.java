package logistics;

public class Driver {
    private String id;
    private String name;
    private boolean available;

    public Driver(String id, String name) {
        this.id = id;
        this.name = name;
        this.available = true;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return name + " (" + (available ? "Available" : "Unavailable") + ")";
    }
}

