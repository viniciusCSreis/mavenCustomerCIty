package br.zup.customerClient;

public interface ICityControler {

    City findOne(int id);
    City findAll();
    City findByName(String name);

}
