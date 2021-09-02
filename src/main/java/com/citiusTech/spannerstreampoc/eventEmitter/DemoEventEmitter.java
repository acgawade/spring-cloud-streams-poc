package com.citiusTech.spannerstreampoc.eventEmitter;

import java.util.Date;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

@Component
public class DemoEventEmitter {
	private final EmitterProcessor<Message<String>> demoEventProcessor = EmitterProcessor.create();

	@Bean
	public Supplier<Flux<Message<String>>> demoEventOutput() {
		return () -> demoEventProcessor;
	}

	@Scheduled(fixedDelay = 3000)
	public void pushEvent() {
		String messageText = "Dude current Time is : " + new Date();
		demoEventProcessor.onNext(MessageBuilder.withPayload(messageText).build());
	}

}
