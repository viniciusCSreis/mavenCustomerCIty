package br.zup.customerClient;

import java.util.ArrayList;

public interface ICityControler {

    City findOne(int id);
    ArrayList<City> findAll();
    City findByName(String name);

}
