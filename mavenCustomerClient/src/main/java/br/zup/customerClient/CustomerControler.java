package br.zup.customerClient;

import java.util.ArrayList;

public class CustomerControler implements ICustomerControler {

    private ICityControler iCityControler;
    public CustomerControler(ICityControler iCityControler) {
        this.iCityControler = iCityControler;
    }

    @Override
    public Customer save(String nameCliente, String nameCity) {
        if(nameCliente.isEmpty())
            return null;
        City city = iCityControler.findByName(nameCity);
        if(city == null)
            return null;
        long cityId = city.getId();
        Customer customer = new Customer(1,nameCliente,cityId);
        CustomerDao.add(customer);
        return customer;
    }

    public ArrayList<Customer> getCustomers() {
        return CustomerDao.getCustomers();
    }
}
