# kafka-producer-bug-app

Lightweight Spring Boot app with a payment-mimic endpoint that sends a hardcoded Kafka message.

## Run

```bash
cd kafka-producer-bug-app
mvn spring-boot:run
```

## Call mock payment endpoint

```bash
curl -X POST http://localhost:8080/payments \
  -H 'Content-Type: application/json' \
  -d '{"paymentId":"test-1","amount":1200}'
```

Each call publishes this hardcoded Kafka message:

```json
{"paymentId":"pay-123","status":"APPROVED","source":"payment-endpoint-mock"}
```

## Config

```bash
export KAFKA_BOOTSTRAP_SERVERS=localhost:9092
export KAFKA_TOPIC=payment-response-topic
export KAFKA_KEY=payment-response
export KAFKA_TIMEOUT_SECONDS=30
```
