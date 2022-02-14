package com.example.pocschemaregistry;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.example.pocschemaregistry.MessageConsumer.TEST_TOPIC_NAME;

@Component
@Slf4j
public class MessageProducer {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Message message) {
        log.info("Producing message={}", message);
        ProducerRecord<String, Message> record = new ProducerRecord<>(TEST_TOPIC_NAME, message);
        kafkaTemplate.send(record);
    }
}
