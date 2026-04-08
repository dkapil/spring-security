package com.example.kafkabug;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentKafkaService {

	private static final String HARDCODED_KAFKA_RESPONSE =
			"{\"paymentId\":\"pay-123\",\"status\":\"APPROVED\",\"source\":\"payment-endpoint-mock\"}";

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Value("${app.kafka.topic}")
	private String topic;

	@Value("${app.kafka.key:payment-response}")
	private String key;

	@Value("${app.kafka.timeout-seconds:30}")
	private long timeoutSeconds;

	public PaymentKafkaService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendHardcodedResponse() throws Exception {
		this.kafkaTemplate.send(this.topic, this.key, HARDCODED_KAFKA_RESPONSE)
				.get(this.timeoutSeconds, TimeUnit.SECONDS);
	}

}
