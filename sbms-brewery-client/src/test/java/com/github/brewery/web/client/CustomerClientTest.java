package com.github.brewery.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.brewery.web.model.CustomerDto;

@SpringBootTest
class CustomerClientTest {

	@Autowired
	private CustomerClient customerClient;

	@Test
	void testGetCustomerById() {
		CustomerDto dto = customerClient.getCustomerById(UUID.randomUUID());
		assertNotNull(dto);
	}

	@Test
	void testSaveCustomer() {
		CustomerDto dto = CustomerDto.builder().name("Amit Bhagra").build();
		URI uri = customerClient.saveCustomer(dto);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}

	@Test
	void testUpdateCustomer() {
		CustomerDto dto = CustomerDto.builder().id(UUID.randomUUID()).name("Asheesh Bhagra").build();
		customerClient.updateCustomer(dto.getId(), dto);

	}

	@Test
	void testDeleteCustomer() {
		customerClient.deleteCustomer(UUID.randomUUID());
	}

}
