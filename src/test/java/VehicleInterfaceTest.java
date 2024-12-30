import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleInterfaceTest {
    class VehicleManager implements VehicleInterface {
        private List<Vehicle> vehicleList;

        public VehicleManager() {
            vehicleList = new java.util.ArrayList<>();
        }

        @Override
        public void addVehicle(Vehicle vehicle) {
            vehicleList.add(vehicle);
        }

        @Override
        public Vehicle getVehicleById(String vehicleId) {
            return vehicleList.stream()
                    .filter(vehicle -> vehicle.getVehicleId().equals(vehicleId))
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public List<Vehicle> getAllVehicles(Class<? extends Vehicle> vehicleType) {
            return vehicleList.stream()
                    .filter(vehicleType::isInstance)
                    .toList();
        }

        @Override
        public boolean rentVehicle(String vehicleId, int days) {
            Vehicle vehicle = getVehicleById(vehicleId);
            if (vehicle != null && vehicle.isAvailable()) {
                vehicle.setAvailable(false);
                return true;
            }
            return false;
        }

        @Override
        public double calculateCost(String vehicleId, int days) {
            Vehicle vehicle = getVehicleById(vehicleId);
            if (vehicle != null) {
                return vehicle.calculateRentalCost(days);
            }
            return 0.0;
        }

        @Override
        public List<Vehicle> getAvailableVehicles() {
            return vehicleList.stream()
                    .filter(Vehicle::isAvailable)
                    .toList();
        }

        @Override
        public List<Vehicle> getAllVehicles() {
            return List.copyOf(vehicleList);
        }
    }

    // JUnit test class
    @Nested
    class vehicleInterfaceTest {
        private VehicleInterface vehicleManager;

        @BeforeEach
        void setUp() {
            vehicleManager = new VehicleManager();
            vehicleManager.addVehicle(new Truck("T001", "Ford F-150", 100.0, true, 2.5));
            vehicleManager.addVehicle(new Motorcycle("M001", "Yamaha R15", 50.0, true));
        }

        @Test
        void testAddVehicle() {
            Vehicle car = new Car("C001", "Toyota Corolla", 70.0, true);
            vehicleManager.addVehicle(car);
            assertNotNull(vehicleManager.getVehicleById("C001"), "Vehicle should be added successfully");
        }

        @Test
        void testGetVehicleById() {
            Vehicle vehicle = vehicleManager.getVehicleById("T001");
            assertNotNull(vehicle, "Vehicle should exist");
            assertEquals("T001", vehicle.getVehicleId(), "Vehicle ID should match");
        }

        @Test
        void testGetAllVehicles() {
            List<Vehicle> allVehicles = vehicleManager.getAllVehicles();
            assertEquals(2, allVehicles.size(), "Should return all added vehicles");
        }

        @Test
        void testGetAllVehiclesByType() {
            List<Vehicle> trucks = vehicleManager.getAllVehicles(Truck.class);
            assertEquals(1, trucks.size(), "Should return only vehicles of type Truck");
        }

        @Test
        void testRentVehicle() {
            boolean success = vehicleManager.rentVehicle("T001", 5);
            assertTrue(success, "Vehicle should be rentable");
            assertFalse(vehicleManager.getVehicleById("T001").isAvailable(), "Vehicle should no longer be available after rental");
        }

        @Test
        void testCalculateCost() {
            double cost = vehicleManager.calculateCost("M001", 3);
            double expectedCost = 50.0 + (150 * 15 * 3); // Base rate + surcharge
            assertEquals(expectedCost, cost, "Cost calculation should be correct");
        }

        @Test
        void testGetAvailableVehicles() {
            vehicleManager.rentVehicle("T001", 5); // Make one vehicle unavailable
            List<Vehicle> availableVehicles = vehicleManager.getAvailableVehicles();
            assertEquals(1, availableVehicles.size(), "Only one vehicle should be available after rental");
            assertEquals("M001", availableVehicles.get(0).getVehicleId(), "The available vehicle should be the motorcycle");
        }
    }

}