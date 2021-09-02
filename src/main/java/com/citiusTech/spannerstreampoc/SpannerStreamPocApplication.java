package com.citiusTech.spannerstreampoc;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpannerStreamPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpannerStreamPocApplication.class, args);
	}

	@Bean
	public Function<Message<String>, String> toUpperCase() {
		return inputValue -> {
			System.out.println("1 uppercasing : " + inputValue);
			return inputValue.getPayload().toUpperCase();
		};
	}

}
