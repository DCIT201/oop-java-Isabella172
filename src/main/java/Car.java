

public class Car extends Vehicle {

    private boolean hasAirConditioning;

    public boolean isHasAirConditioning() {
        return hasAirConditioning;
    }

    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }

    public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        this.hasAirConditioning = hasAirConditioning;
    }


    @Override
    public double calculateRentalCost(int days) {
        if (hasAirConditioning) {
            return getBaseRentalRate() * days;
        }
        return getBaseRentalRate();

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
                ", hasAirConditioning=" + hasAirConditioning +
                '}';
    }

}