package fasttrack.model;

import java.util.ArrayList;
import java.util.List;

public class DriverModel {
    private final List<Driver> drivers= new ArrayList<>();



    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void updateDriver(Driver updatedDriver) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getId() == updatedDriver.getId()) {
                drivers.set(i, updatedDriver);
                break;
            }
        }
    }

    public void removeDriver(int id) {
        drivers.removeIf(driver -> driver.getId() == id);
    }

    public List<Driver> getAllDrivers() {
        return drivers;
    }

}
