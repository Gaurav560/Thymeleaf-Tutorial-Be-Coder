package com.ineuron.ai;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
@SpringBootApplication
public class SpringBootCallAppUsingTwilioApplication implements ApplicationRunner {

	private final static String SID_ACCOUNT = "ACdd0a8aacb7109d03af5aca57c978192a";
	private final static String AUTH_ID = "f545f6eeba1bedf54a5a666d82eca203";
	private final static String FROM_NUMBER = "+12512921424";
	private final static String TO_NUMBER = "+919523849635";

	static {
		Twilio.init(SID_ACCOUNT, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCallAppUsingTwilioApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				new URI("http://demo.twilio.com/docs/voice.xml")).create();

	}
}
