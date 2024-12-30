
import java.util.ArrayList;
import java.util.List;


public class Customer {
    private String customerId;
    private String name;
    private String contactInfo;
    private List<String> rentalHistory;
    private int loyaltyPoints;

    // Constructor
    public Customer(String customerId, String name) {
        if (customerId == null || customerId.isEmpty() || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Customer ID and Name cannot be null or empty.");
        }
        this.customerId = customerId;
        this.name = name;
        this.contactInfo = contactInfo != null ? contactInfo : "Not provided";
        this.rentalHistory = new ArrayList<>();
        this.loyaltyPoints = 0;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<String> getRentalHistory() {
        return new ArrayList<>(rentalHistory); // Return a copy to preserve encapsulation
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }


    public void addRentalToHistory(String vehicleDetails) {
        if (vehicleDetails != null && !vehicleDetails.isEmpty()) {
            rentalHistory.add(vehicleDetails);
        } else {
            System.out.println("Invalid vehicle details provided.");
        }
    }


    public void addLoyaltyPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }


    public boolean isEligibleForRental() {
        return loyaltyPoints >= 10 || rentalHistory.size() < 5;
    }


    @Override
    public String toString() {
        return "Customer ID: " + customerId +
                "\nName: " + name +
                "\nContact Info: " + contactInfo +
                "\nLoyalty Points: " + loyaltyPoints +
                "\nRental History: " + rentalHistory;
    }

    public void addRating(int i) {
    }
}
