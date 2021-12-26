package com.example.promotion.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PromotionEngineApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PromotionEngineApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
		return builder.sources(PromotionEngineApplication.class);
	}

}
