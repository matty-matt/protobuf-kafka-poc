package com.example.pocschemaregistry;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private String content;
    private String subject;
    private Date receivedDate;
}
