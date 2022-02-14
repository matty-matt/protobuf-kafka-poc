package com.example.pocschemaregistry;

import com.example.simplemessage.SimpleMessageProtos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MessageController {
    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/produce")
    public void produce() {
        SimpleMessageProtos.SimpleMessage message = SimpleMessageProtos.SimpleMessage.newBuilder()
                .setContent("TEST CONTENT")
                .setSomeNumber(123)
                .setReceivedDate(new Date().toString())
                .build();
        this.messageProducer.send(message);
    }
}
