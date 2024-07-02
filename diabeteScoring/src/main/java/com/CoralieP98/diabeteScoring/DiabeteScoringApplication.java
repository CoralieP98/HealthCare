package com.CoralieP98.diabeteScoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RefreshScope
public class DiabeteScoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiabeteScoringApplication.class, args);
	}

}
