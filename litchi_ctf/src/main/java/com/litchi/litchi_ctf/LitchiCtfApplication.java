package com.litchi.litchi_ctf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication()
public class LitchiCtfApplication {

	public static void main(String[] args) {
		SpringApplication.run(LitchiCtfApplication.class, args);
	}
}
