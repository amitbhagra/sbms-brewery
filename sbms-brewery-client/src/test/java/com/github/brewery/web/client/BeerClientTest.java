package com.github.brewery.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.brewery.web.model.BeerDto;

@SpringBootTest
class BeerClientTest {

	@Autowired
	private BeerClient beerClient;

	@Test
	void testGetBeerById() {
		BeerDto dto = beerClient.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
	}

	@Test
	void testSaveBeer() {
		BeerDto dto = BeerDto.builder().beerName("Budweiser").beerStyle("Lager").build();
		URI uri = beerClient.saveBeer(dto);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}

	@Test
	void testUpdateBeer() {
		BeerDto dto = BeerDto.builder().id(null).beerName("Budweiser").beerStyle("").upc(11111L).build();
		beerClient.updateBeer(UUID.randomUUID(), dto);

	}

	@Test
	void testDeleteBeer() {
		beerClient.deleteBeer(UUID.randomUUID());
	}

}
