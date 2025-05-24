package logistics;

import java.util.List;

public class AssignmentManager {
    public static boolean assignDriverToShipment(Shipment shipment, List<Driver> drivers) {
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                shipment.setAssignedDriver(driver);
                driver.setAvailable(false);
                return true;
            }
        }
        return false;
    }
}

