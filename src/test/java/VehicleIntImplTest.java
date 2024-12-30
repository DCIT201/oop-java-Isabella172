import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleIntImplTest {
    @Nested
    class vehicleintimpltest {
        private VehicleIntImpl vehicleManager;

        @BeforeEach
        void setUp() {
            vehicleManager = new VehicleIntImpl();
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
        void testAddDuplicateVehicle() {
            Vehicle duplicateTruck = new Truck("T001", "Ford F-150", 100.0, true, 2.5);
            assertThrows(IllegalArgumentException.class, () -> vehicleManager.addVehicle(duplicateTruck),
                    "Adding a duplicate vehicle should throw an exception");
        }

        @Test
        void testGetVehicleById() {
            Vehicle vehicle = vehicleManager.getVehicleById("T001");
            assertNotNull(vehicle, "Vehicle should exist");
            assertEquals("T001", vehicle.getVehicleId(), "Vehicle ID should match");
        }

        @Test
        void testGetVehicleByIdNonexistent() {
            assertNull(vehicleManager.getVehicleById("X999"), "Nonexistent vehicle ID should return null");
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
        void testRentUnavailableVehicle() {
            vehicleManager.rentVehicle("T001", 5); // Make it unavailable
            assertThrows(IllegalArgumentException.class, () -> vehicleManager.rentVehicle("T001", 3),
                    "Renting an unavailable vehicle should throw an exception");
        }

        @Test
        void testCalculateCost() {
            double cost = vehicleManager.calculateCost("M001", 3);
            double expectedCost = 50.0 + (150 * 15 * 3); // Base rate + surcharge
            assertEquals(expectedCost, cost, "Cost calculation should be correct");
        }

        @Test
        void testCalculateCostUnavailableVehicle() {
            assertThrows(IllegalArgumentException.class, () -> vehicleManager.calculateCost("X999", 5),
                    "Calculating cost for a nonexistent vehicle should throw an exception");
        }

        @Test
        void testGetAvailableVehicles() {
            vehicleManager.rentVehicle("T001", 5); // Make one vehicle unavailable
            List<Vehicle> availableVehicles = vehicleManager.getAvailableVehicles();
            assertEquals(1, availableVehicles.size(), "Only one vehicle should be available after rental");
            assertEquals("M001", availableVehicles.getFirst().getVehicleId(), "The available vehicle should be the motorcycle");
        }

        @Test
        void testGetAllVehicles() {
            List<Vehicle> allVehicles = vehicleManager.getAllVehicles();
            assertEquals(2, allVehicles.size(), "Should return all added vehicles");
        }
    }

}