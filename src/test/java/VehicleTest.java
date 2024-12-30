import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    private Vehicle vehicle;

        @BeforeEach
        void setUp() {
            vehicle = new Truck("V001", "Generic Model", 50.0, true, 1.5);
        }

        @Test
        void testGetVehicleId() {
            assertEquals("V001", vehicle.getVehicleId(), "Vehicle ID should be 'V001'");
        }

        @Test
        void testSetVehicleId() {
            vehicle.setVehicleId("V002");
            assertEquals("V002", vehicle.getVehicleId(), "Vehicle ID should be updated to 'V002'");
        }

        @Test
        void testGetModel() {
            assertEquals("Generic Model", vehicle.getModel(), "Model should be 'Generic Model'");
        }

        @Test
        void testSetModel() {
            vehicle.setModel("New Model");
            assertEquals("New Model", vehicle.getModel(), "Model should be updated to 'New Model'");
        }

        @Test
        void testGetBaseRentalRate() {
            assertEquals(50.0, vehicle.getBaseRentalRate(), "Base rental rate should be 50.0");
        }

        @Test
        void testSetBaseRentalRate() {
            vehicle.setBaseRentalRate(60.0);
            assertEquals(60.0, vehicle.getBaseRentalRate(), "Base rental rate should be updated to 60.0");
        }

        @Test
        void testIsAvailable() {
            assertTrue(vehicle.isAvailable(), "Vehicle should initially be available");
        }

        @Test
        void testSetAvailable() {
            vehicle.setAvailable(false);
            assertFalse(vehicle.isAvailable(), "Vehicle should not be available after update");
        }

        @Test
        void testCalculateRentalCost() {
            double rentalCost = vehicle.calculateRentalCost(3);
            double expectedCost = 50.0 + (1.5 * 3 * 15);
            assertEquals(expectedCost, rentalCost, "Rental cost calculation is incorrect");
        }

        @Test
        void testIsAvailableForRental() {
            assertTrue(vehicle.isAvailableForRental(), "Vehicle should be available for rental initially");

            vehicle.setAvailable(false);
            assertFalse(vehicle.isAvailableForRental(), "Vehicle should not be available for rental after update");
        }
    }

