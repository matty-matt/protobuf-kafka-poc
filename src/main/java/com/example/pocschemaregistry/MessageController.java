package com.example.pocschemaregistry;

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
        Message message = new Message();
        message.setContent("TEST CONTENT");
        message.setSomeNumber(123);
        message.setReceivedDate(new Date());
        this.messageProducer.send(message);
    }
}
