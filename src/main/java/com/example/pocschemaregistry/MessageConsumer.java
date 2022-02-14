package com.example.pocschemaregistry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {
    public static final String TEST_TOPIC_NAME = "test-mkociszewski-schema-registry";

    @KafkaListener(
            groupId = "test-mkociszewski-group-id",
            topics = TEST_TOPIC_NAME,
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(Message message) {
        log.info("Read, record={}", message);
    }
}
