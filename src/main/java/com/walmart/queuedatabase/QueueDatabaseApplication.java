package com.walmart.queuedatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class QueueDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueDatabaseApplication.class, args);
	}

}
