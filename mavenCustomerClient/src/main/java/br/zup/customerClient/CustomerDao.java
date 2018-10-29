package br.zup.customerClient;

import java.util.ArrayList;

public class CustomerDao {

    static ArrayList<Customer> customers = new ArrayList<>();

    protected static void add(Customer customer){
        customers.add(customer);
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}
