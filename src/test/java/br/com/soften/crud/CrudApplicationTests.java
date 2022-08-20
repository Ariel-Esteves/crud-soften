package br.com.soften.crud;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.models.entities.Product;
import br.com.soften.crud.models.entities.Sales;
import br.com.soften.crud.models.entities.pk.OrderItemPk;
import br.com.soften.crud.models.enums.States;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrudApplicationTests {

	@Test
	void contextLoads() {
		Client client = new Client();
		client.setName("Ariel");
		client.setCpf(460);
		client.setCep(152);
		client.setCity("José b");
		client.setIe("123");
		client.setAddress("Suspense");
		client.setDistrict("ok");
		client.setNumber(321);
		client.setComplement("test");
		client.setState(States.AMAZONAS);

		Product product = new Product();
		product.setName("Ariel");
		product.setCostValue(25);
		product.setSaleValue(85);
		Sales sales = new Sales();
		sales.setId(new OrderItemPk( client.getId(), product.getId() ));
	}

}
