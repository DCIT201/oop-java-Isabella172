

import java.util.ArrayList;
import java.util.List;


public class RentalAgency {
    private List<Vehicle> fleet;

    public RentalAgency() {
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public Vehicle findAvailableVehicle(String model) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getModel().equalsIgnoreCase(model) && vehicle.isAvailableForRental()) {
                return vehicle;
            }
        }
        return null;
    }

    public void rentVehicle(String model, Customer customer, int days) {
        Vehicle vehicle = findAvailableVehicle(model);
        if (vehicle != null && vehicle instanceof Rentable) {
            ((Rentable) vehicle).rent(customer, days);
        } else {
            System.out.println("No available " + model + " found.");
        }
    }

    public int getFleetSize() {
        return 0;
    }
}
