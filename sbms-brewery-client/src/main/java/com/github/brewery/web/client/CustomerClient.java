package com.github.brewery.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.github.brewery.web.model.CustomerDto;

@ConfigurationProperties(prefix = "mssb.brewery", ignoreUnknownFields = false)
@Component
public class CustomerClient {

	private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
	private String apiHost;
	private final RestTemplate restTemplate;

	public CustomerDto getCustomerById(UUID id) {
		return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + id, CustomerDto.class);
	}
	
	public URI saveCustomer(CustomerDto dto) {
		return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, dto);
	}
	
	public void updateCustomer(UUID id, CustomerDto dto) {
		restTemplate.put(apiHost + CUSTOMER_PATH_V1 + id.toString(), dto);
	}
	
	public void deleteCustomer(UUID id) {
		restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + id.toString());
	}
	
	public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}

}
