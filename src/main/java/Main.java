public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        Vehicle car = new Car("C001", "Toyota Camry", 50, true);
        Vehicle bike = new Motorcycle("M001", "Yamaha", 20, true); // Adjusted Motorcycle availability
        Vehicle truck = new Truck("T001", "Volvo", 100, true,3.5); // Adjusted Truck availability

        agency.addVehicle(car);
        agency.addVehicle(bike);
        agency.addVehicle(truck);

        Customer customer = new Customer("John Doe", "L12345");
        agency.rentVehicle("Toyota Camry", customer, 5); // Use model names, not IDs
        agency.rentVehicle("Yamaha", customer, 3);      // Use model names, not IDs
    }
}
