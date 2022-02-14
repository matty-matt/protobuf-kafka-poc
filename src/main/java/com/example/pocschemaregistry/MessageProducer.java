package com.example.pocschemaregistry;

import com.example.simplemessage.SimpleMessageProtos;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.example.pocschemaregistry.MessageConsumer.TEST_TOPIC_NAME;

@Component
@Slf4j
public class MessageProducer {

    private final KafkaTemplate<String, SimpleMessageProtos.SimpleMessage> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, SimpleMessageProtos.SimpleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(SimpleMessageProtos.SimpleMessage message) {
        log.info("Producing message={}", message);
        ProducerRecord<String, SimpleMessageProtos.SimpleMessage> record = new ProducerRecord<>(TEST_TOPIC_NAME, message);
        kafkaTemplate.send(record);
    }
}
