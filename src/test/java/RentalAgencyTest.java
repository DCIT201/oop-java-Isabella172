import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {

    private RentalAgency rentalAgency;
    private Vehicle car;
    private Vehicle motorcycle;
    private Customer customer;

    @BeforeEach
    void setUp() {
        rentalAgency = new RentalAgency();
        customer = new Customer("001", "John Doe");

        // Initialize some vehicles for testing
        car = new Car("C001", "Toyota Corolla", 100.0, true);
        motorcycle = new Motorcycle("M001", "Yamaha R1", 50.0, true);

        // Add vehicles to the fleet
        rentalAgency.addVehicle(car);
        rentalAgency.addVehicle(motorcycle);
    }

    @Test
    void testAddVehicle() {
        Vehicle truck = new Truck("T001", "Ford F-150", 150.0, true, 2000);
        rentalAgency.addVehicle(truck);

        // Check that the truck was added successfully
        assertEquals(3, rentalAgency.getFleetSize(), "The fleet size should be 3 after adding a truck.");
    }

    @Test
    void testFindAvailableVehicle() {
        Vehicle foundVehicle = rentalAgency.findAvailableVehicle("Toyota Corolla");
        assertNotNull(foundVehicle, "Available vehicle should be found.");
        assertEquals("Toyota Corolla", foundVehicle.getModel(), "The model of the found vehicle should be Toyota Corolla.");
    }
    @Test
    public void rentVehicle() {
        String model = "";
        Vehicle vehicle = findAvailableVehicle(model);
        if (vehicle != null && vehicle instanceof Rentable) {
            Rentable rentableVehicle = (Rentable) vehicle;
            int days = 0;
            rentableVehicle.rent(customer, days);
        } else {
            System.out.println("No available " + model + " found.");
        }
    }

    private Vehicle findAvailableVehicle(String model) {
        return null;
    }



    @Test
    void testRentNonexistentVehicle() {
        rentalAgency.rentVehicle("Nonexistent Model", customer, 5);
        Vehicle nonexistentVehicle = rentalAgency.findAvailableVehicle("Nonexistent Model");
        assertNull(nonexistentVehicle, "A nonexistent vehicle should not be found.");
    }
}

