package com.example.demo;

import com.github.messenger4j.MessengerPlatform;
import com.github.messenger4j.send.MessengerSendClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDocBotApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringDocBotApplication.class);

	//Parameters to connect to watson
	private static final String WATSON_CONVERSATION_USERNAME = "943cfb53-53e2-4b4d-b89a-32180ca0d732";
	private static final String WATSON_CONVERSATION_PASSWORD = "qW6NbHIzMBnL";
	private static final String WATCON_CONVERSATION_WORKSPACE_ID = "b3da6be6-940b-4717-9013-8907d80fb00e";

	/**
	 * Initializes the {@code MessengerSendClient}.
	 *
	 * @param pageAccessToken the generated {@code Page Access Token}
	 */
	@Bean
	public MessengerSendClient messengerSendClient(@Value("${messenger4j.pageAccessToken}") String pageAccessToken) {
		logger.debug("Initializing MessengerSendClient - pageAccessToken: {}", pageAccessToken);
		return MessengerPlatform.newSendClientBuilder(pageAccessToken).build();
	}


	public static void main(String[] args) {


		SpringApplication.run(SpringDocBotApplication.class, args);


	}
}
