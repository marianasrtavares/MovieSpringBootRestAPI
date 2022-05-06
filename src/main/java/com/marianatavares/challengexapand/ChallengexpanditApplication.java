package com.marianatavares.challengexapand;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengexpanditApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengexpanditApplication.class, args);

	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
