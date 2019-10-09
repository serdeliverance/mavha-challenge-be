package com.mavha.mavhachallengetodobespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.mavha.mavhachallengetodobespring.storage.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class MavhaChallengeTodoBeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavhaChallengeTodoBeSpringApplication.class, args);
	}

}
