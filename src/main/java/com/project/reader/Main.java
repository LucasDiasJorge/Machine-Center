package com.project.reader;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));

		System.out.println(" MACHINE CENTER is running ... ");
		SpringApplication.run(Main.class, args);
	}

}
