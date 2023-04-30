package com.microservice.servicejob;

import com.microservice.servicejob.entity.ThemeParkRide;
import com.microservice.servicejob.repository.ThemeParkRideRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ServiceJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceJobApplication.class, args);
	}

	@Bean
	public CommandLineRunner exampleMetaData(ThemeParkRideRepository themeParkRideRepository){
		log.info("execute exampleMetaData");
		return (args) -> {
			themeParkRideRepository.save(new ThemeParkRide("Roller coaster", "Train ride that speeds you along", 1, 2));
			themeParkRideRepository.save(new ThemeParkRide("Log flume", "Boat ride with plenty of splashes", 1, 2));
			themeParkRideRepository.save(new ThemeParkRide("Teacups", "Spinning ride in a giant tea cups", 1, 2));
		};
	}
}
