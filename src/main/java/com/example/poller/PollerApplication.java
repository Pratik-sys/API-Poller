package com.example.poller;

import com.example.poller.api.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class PollerApplication implements CommandLineRunner {

	@Autowired
	private API api;

	public static void main(String[] args) {
		SpringApplication.run(PollerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		api.fetchContent();
	}
}


