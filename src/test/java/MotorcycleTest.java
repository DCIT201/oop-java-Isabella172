import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {
        private Motorcycle motorcycle;

        @BeforeEach
        void setUp() {
            // Initialize a Motorcycle object before each test
            motorcycle = new Motorcycle("M001", "Yamaha R15", 50.0, true);
            motorcycle.setEngineCapacity(150); // Set engine capacity separately
        }

        @Test
        void testGetEngineCapacity() {
            // Test the getter for engine capacity
            assertEquals(150, motorcycle.getEngineCapacity(), "Engine capacity should be 150 cc");
        }

        @Test
        void testSetEngineCapacity() {
            // Update the engine capacity and verify
            motorcycle.setEngineCapacity(200);
            assertEquals(200, motorcycle.getEngineCapacity(), "Engine capacity should be updated to 200 cc");
        }

        @Test
        void testCalculateRentalCost() {
            double rentalCost = motorcycle.calculateRentalCost(3);
            double expectedCost = 50.0 + (150 * 15 * 3);
            assertEquals(expectedCost, rentalCost, "Rental cost calculation is incorrect");
        }

        @Test
        void testIsAvailableForRental() {
            assertTrue(motorcycle.isAvailableForRental(), "Motorcycle should initially be available for rental");
            motorcycle.setAvailable(false);
            assertFalse(motorcycle.isAvailableForRental(), "Motorcycle should not be available for rental after update");
        }

        @Test
        void testToString() {

            String expectedString = "Car{" +
                    "vehicleId='M001', model='Yamaha R15', baseRentalRate=50.0, isAvailable=true, engineCapacity=150}";
            assertEquals(expectedString, motorcycle.toString(), "toString output is incorrect");
        }
    }

