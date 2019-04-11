package com.lily.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class ChatMessage {
    private String content;
    private String sender;
    private String receiver;
}
