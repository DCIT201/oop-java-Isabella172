
public class Truck extends Vehicle {

    private double loadCapacity;

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Truck(String vehicleId, String model, double baseRentalRate, boolean isAvailable, double loadCapacity) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        this.loadCapacity = loadCapacity;
    }


    @Override
    public double calculateRentalCost(int daysRented) {
        double basePrice = getBaseRentalRate();
        double surcharge = loadCapacity * daysRented * 15;
        return basePrice + surcharge;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
    @Override
    public String toString() {
        return "Truck{" +
                "vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                ", isAvailable=" + isAvailable() +
                ", loadCapacity=" + loadCapacity +
                '}';
    }
}
