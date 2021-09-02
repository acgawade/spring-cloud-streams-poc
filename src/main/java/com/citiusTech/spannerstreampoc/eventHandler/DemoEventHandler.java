package com.citiusTech.spannerstreampoc.eventHandler;

import java.util.function.Consumer;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("demoEventInput")
public class DemoEventHandler implements Consumer<Message<String>> {

	@Override
	public void accept(Message<String> message) {
		System.out.println("Demo incoming message is : " + message.getPayload());

	}

}
