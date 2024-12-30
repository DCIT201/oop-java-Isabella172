
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class VehicleIntImpl implements VehicleInterface {

    private final Map<String, Vehicle> vehicleDB = new HashMap<>();


    public void addVehicle(Vehicle vehicle) {
        if (vehicleDB.containsKey(vehicle.getVehicleId())){
            throw new IllegalArgumentException("Vehicle already exists");
        }
        vehicleDB.put(vehicle.getVehicleId(), vehicle);
    }


    public Vehicle getVehicleById(String vehicleId) {
        return vehicleDB.get(vehicleId);
    }


    public List<Vehicle> getAllVehicles(Class<? extends Vehicle> type) {
        return vehicleDB.values()
                .stream()
                .filter(vehicle -> type.isInstance(vehicle) && vehicle.isAvailable())
                .toList  ();
    }


    public boolean rentVehicle(String vehicleId, int days) {
        Vehicle vehicle = vehicleDB.get(vehicleId);
        if(vehicle != null && vehicle.isAvailable()) {
            System.out.println(vehicle.getModel() + " has been rented for " + days + " days");
            vehicle.setAvailable(false);
        }
        throw new IllegalArgumentException("The vehicle you're looking for is currently unavailable");

    }


    public double calculateCost(String vehicleId, int days) {
        Vehicle vehicle = vehicleDB.get(vehicleId);
        if(vehicle != null) {
            return vehicle.calculateRentalCost(days);
        }
        throw new IllegalArgumentException("The vehicle you're looking for is currently unavailable");
    }


    public List<Vehicle> getAvailableVehicles() {
        return List.of();
    }


    public List<Vehicle> getAllVehicles() {
        return List.copyOf(vehicleDB.values());
    }
}