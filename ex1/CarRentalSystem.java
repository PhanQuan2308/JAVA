package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    //fields
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    //Constructor

    public  CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    //methob
    public  void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public  void  rentCar(Car car, Customer customer, int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        }else {
            System.out.println("Car is not available for rent.");
        }
    }
    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove = null;
        for(Rental rental : rentals){
            if (rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }
        if(rentalToRemove != null){
            rentals.remove(rentalToRemove);
            System.out.println("Car returned successfully.");
        }else{
            System.out.println("Car was not found");
        }
    }
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=====Car Rental System ========");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("Enter your Choice");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("\n== Rent a Car ==");
                    System.out.println("Enter your name: ");
                    String customerName = sc.nextLine();

                    System.out.println("\n Available Car");
                    for(Car car: cars){
                        if(car.isAvailable()){
                            System.out.println(car.getCarId() + " - " + car.getBrand() + " - " + car.getModel());
                        }
                    }
                    System.out.println("\n Enter the car ID you want to rent: ");
                    String carId = sc.nextLine();

                    System.out.println("\n Enter the number of  days for rental: ");
                    int rentalDays = sc.nextInt();

                    Customer newCustomer = new Customer("CUS" + (customers.size()+1), customerName);
                    addCustomer(newCustomer);

                    Car selectedCar = null;
                    for (Car car : cars){
                        if(car.getCarId().equals(carId) && car.isAvailable()){
                            selectedCar = car;
                            break;
                        }
                    }
                    if(selectedCar != null){
                        double totalPrice = selectedCar.calculatePrice(rentalDays);
                        System.out.println("\n ======== Rental Information ======= \n");
                        System.out.println("Customer ID: " + newCustomer.getCustomerId());
                        System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                        System.out.println("Rental Days: " + rentalDays);
                        System.out.println("Total Price: " + totalPrice);

                        System.out.println("\nConfirm rental (Y/N): ");
                        String confirm = sc.next();

                        if(confirm.equalsIgnoreCase("Y")){
                            rentCar(selectedCar, newCustomer, rentalDays);
                            System.out.println("\n Car rented successfully");

                        }else{
                            System.out.println("\n Rental cancel.");

                        }

                    }else {
                        System.out.println("Invalid car selection or car not available for rent.");
                    }
                    break;

                case 2:
                    System.out.println("\n == Return  a Car ==");
                    System.out.println("Enter the car ID you want to return: ");
                    sc.nextLine(); // Đọc kí tự newline còn tồn tại trong bộ nhớ đệm của Scanner
                    String carIdToReturn = sc.nextLine();

                    Car carToReturn = null;
                    for(Car car: cars){
                        if(car.getCarId().equals(carIdToReturn) && !car.isAvailable()){
                            carToReturn = car;
                            break;
                        }
                    }
                    if(carToReturn != null){
                        Customer customer = null;
                        for (Rental rental : rentals){
                            if(rental.getCar() == carToReturn){
                                customer = rental.getCustomer();
                                break;
                            }
                        }
                        if(customer != null){
                            returnCar(carToReturn);
                            System.out.println("Car returned successfully by customer: " + customer.getName());
                        } else {
                            System.out.println("Error: Rental information not found for the car.");
                        }
                    } else {
                        System.out.println("Error: Car not found or already available.");
                    }
                    break;


                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);
    }

}
