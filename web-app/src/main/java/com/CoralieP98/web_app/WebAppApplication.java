package com.CoralieP98.web_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

//@EnableJpaRepositories("com.CoralieP98.msaccount.repository")
//@ComponentScans({@ComponentScan("com.CoralieP98.webapp.controller")})
//@EntityScan("com.CoralieP98.webapp.model")
@SpringBootApplication
@EnableFeignClients
@RefreshScope
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

}
