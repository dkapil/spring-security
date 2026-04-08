package com.example.kafkabug;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private final PaymentKafkaService paymentKafkaService;

	public PaymentController(PaymentKafkaService paymentKafkaService) {
		this.paymentKafkaService = paymentKafkaService;
	}

	@PostMapping
	public ResponseEntity<Map<String, String>> createPayment(@RequestBody(required = false) String requestPayload)
			throws Exception {
		this.paymentKafkaService.sendHardcodedResponse();
		return ResponseEntity.accepted().body(Map.of(
				"status", "ACCEPTED",
				"message", "Payment received and Kafka message sent",
				"requestPayload", requestPayload == null ? "" : requestPayload));
	}

}
