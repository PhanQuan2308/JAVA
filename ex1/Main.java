package ex1;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem carRentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "Toyota","Camry", 50);
        Car car2 = new Car("C002", "Honda", "Accord", 70);

        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.menu();
    }
}
