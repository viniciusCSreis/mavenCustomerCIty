package br.zup.customerClient;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControlerTest {

    @Mock
    private ICityControler iCityControler;
    private CustomerControler customerControler;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.initMocks(this);
        this.customerControler = new CustomerControler(iCityControler);
    }

    @Test
    public void canSaveACity(){
        String cityName = "uberlândia";
        City uberlandia = new City(100,cityName);

        when(iCityControler.findByName(cityName)).thenReturn(uberlandia);

        Customer customer = customerControler.save("vinicius",cityName);

        assertEquals(customer.getCityId(),100);
        assertTrue(customerControler.getCustomers().size() > 0);
        assertTrue(customerControler.getCustomers().indexOf(customer) != -1);

        verify(iCityControler,atLeast(1)).findByName(cityName);

    }
    @Test
    public void SavaACustomerWithoutCityName(){
        String cityName = "";
        when(iCityControler.findByName(cityName)).thenReturn(null);
        Customer customer = customerControler.save("vinicius",cityName);

        assertEquals(customer,null);

        verify(iCityControler,atLeast(1)).findByName(cityName);

    }
    @Test
    public void SavaACustomerWithoutCustomerName(){String cityName = "uberlândia";
        City uberlandia = new City(100,cityName);

        when(iCityControler.findByName(cityName)).thenReturn(uberlandia);

        Customer customer = customerControler.save("",cityName);

        assertEquals(customer,null);
    }
    @Test
    public void SavaACustomerWithWrong(){

        String cityName = "uberlândia";
        when(iCityControler.findByName(cityName)).thenReturn(null);

        Customer customer = customerControler.save("",cityName);

        assertEquals(customer,null);
    }





}