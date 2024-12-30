import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CustomerTest {
  private Customer customer;
  @BeforeEach
    void setUp() {
      customer = new Customer("50", "Abena Ella" ) ;

  }
    @Test
    void getName() {
      assertEquals("Abena Ella", customer.getName());
    }
    @Test
  void AddRentalToHistory() {
    customer.addRentalToHistory( "Toyota");
    assertTrue(customer.getRentalHistory().contains("Toyota"));
    }
}
