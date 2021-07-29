package com.zup.rodolpho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@SpringBootApplication
public class RodolphoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RodolphoApplication.class, args);
	}

}
