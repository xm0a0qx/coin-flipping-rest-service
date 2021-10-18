package com.sample.coinflippingrestservice;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoinFlippingRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinFlippingRestServiceApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("v0.1") String appVersion){
		return new OpenAPI()
				.components(new Components())
				.info(new Info().title("Coin flipper API").version(appVersion));
	}

}
