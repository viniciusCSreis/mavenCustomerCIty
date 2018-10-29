package br.zup.customerClient;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {


    @Test
    public void simpleTest()
    {
        HelloWorld h = new HelloWorld();
        assertEquals(h.test(),0,0.0001);
    }


}