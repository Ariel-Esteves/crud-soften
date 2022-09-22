package br.com.soften.crud;

import br.com.soften.crud.controller.OrderSalesController;
import br.com.soften.crud.models.entities.Client;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest // is used to run jpa with our test
class CrudApplicationTests{
    @Autowired
    OrderSalesController orderSalesController;

    //@AfterEach is used to notate a function and make it be executed everytime that the test is used
    @BeforeAll
    void createData(){
        Client client = new Client();
    }
    @Test
    void VerifyIfWork(){
        int number0 = 1;
        int number1 = 2;
        //assertThat is a method that usually is import as static method.
        assertThat(number0 + number1).isEqualTo(3);
    }



}
