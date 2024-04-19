package ex1;

public class Customer {
    //fields
    private String customerId;
    private  String name;



    //Constructor


    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    //Methob
    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

}
