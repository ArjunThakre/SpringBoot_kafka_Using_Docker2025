package com.example.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {
      private String id;
      private String messageContent;
      private String sender;

    public String getId() {
        return id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getSender() {
        return sender;
    }
}
