
public class Motorcycle extends Vehicle {

    private int engineCapacity;

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public double calculateRentalCost(int daysRented) {
        double baseRentalRate = getBaseRentalRate();
        double surcharge = engineCapacity * 15 * daysRented; //*25 for everyday of use
        return baseRentalRate + surcharge;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public String toString() {
        return "Car{" +
                "vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                ", isAvailable=" + isAvailable() +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
