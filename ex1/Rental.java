package ex1;

public class Rental {
    //fields
    private Car car;
    private Customer customer;
    private int days;


    //Constructor
    public Rental(Car car, Customer customer, int days){
        this.car =car;
        this.customer = customer;
        this.days  = days;
    }



    //Methob
    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

}
