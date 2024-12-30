import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    public class Main {
        public static void main(String[] args) {

            Car car1 = new Car("C001", "Toyota Corolla", 50.0, true);
            car1.setHasAirConditioning(true);

            Car car2 = new Car("C001", "Honda Civic", 60.0, false);
            car2.setHasAirConditioning(false);


            Car car3 = new Car("C002", "Ford Focus", 45.0, true);
            car3.setHasAirConditioning(true);


            System.out.println("car1 equals car2: " + car1.equals(car2));
            System.out.println("car1 equals car3: " + car1.equals(car3));
        }
    }

}