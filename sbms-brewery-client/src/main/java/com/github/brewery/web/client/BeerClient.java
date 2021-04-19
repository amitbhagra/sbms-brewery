package com.github.brewery.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.github.brewery.web.model.BeerDto;

@ConfigurationProperties(prefix = "mssb.brewery", ignoreUnknownFields = false)
@Component
public class BeerClient {

	private final String BEER_PATH_V1 = "/api/v1/beer/";
	private String apiHost;
	private final RestTemplate restTemplate;

	public BeerDto getBeerById(UUID id) {
		return restTemplate.getForObject(apiHost + BEER_PATH_V1 + id, BeerDto.class);
	}
	
	public URI saveBeer(BeerDto dto) {
		return restTemplate.postForLocation(apiHost + BEER_PATH_V1, dto);
	}
	
	public void updateBeer(UUID id, BeerDto dto) {
		restTemplate.put(apiHost + BEER_PATH_V1 + id.toString(), dto);
	}
	
	public void deleteBeer(UUID id) {
		restTemplate.delete(apiHost + BEER_PATH_V1 + id.toString());
	}
	
	public BeerClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}

}
