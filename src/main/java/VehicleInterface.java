
import java.util.List;
import java.util.UUID;

public interface VehicleInterface {
    void addVehicle(Vehicle vehicle);

    Vehicle getVehicleById(String vehicleId);

    List<Vehicle> getAllVehicles(Class <? extends Vehicle> vehicle);

    boolean rentVehicle(String vehicleId, int days);

    double calculateCost(String vehicleId, int days);

    List<Vehicle> getAvailableVehicles();

    List<Vehicle> getAllVehicles();
}