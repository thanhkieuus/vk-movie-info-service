package com.vk.movieinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VkMovieInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VkMovieInfoServiceApplication.class, args);
	}

}
