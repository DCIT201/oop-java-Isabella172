import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
        private Truck truck;

        @BeforeEach
        void setUp() {
            // Initialize a Truck object before each test
            truck = new Truck("T001", "Ford F-150", 100.0, true, 2.5);
        }

        @Test
        void testGetLoadCapacity() {
            // Test the getter for load capacity
            assertEquals(2.5, truck.getLoadCapacity(), "Load capacity should be 2.5 tons");
        }

        @Test
        void testSetLoadCapacity() {
            // Update the load capacity and verify
            truck.setLoadCapacity(3.0);
            assertEquals(3.0, truck.getLoadCapacity(), "Load capacity should be updated to 3.0 tons");
        }

        @Test
        void testCalculateRentalCost() {
            // Test the rental cost calculation
            double rentalCost = truck.calculateRentalCost(5); // Renting for 5 days
            double expectedCost = 100.0 + (2.5 * 5 * 15);
            assertEquals(expectedCost, rentalCost, "Rental cost calculation is incorrect");
        }

        @Test
        void testIsAvailableForRental() {
            assertTrue(truck.isAvailableForRental(), "Truck should initially be available for rental");
            truck.setAvailable(false);
            assertFalse(truck.isAvailableForRental(), "Truck should not be available for rental after update");
        }

        @Test
        void testToString() {
            String expectedString = "Truck{vehicleId='T001', model='Ford F-150', baseRentalRate=100.0, isAvailable=true, loadCapacity=2.5}";
            assertEquals(expectedString, truck.toString(), "toString output is incorrect");
        }
    }

