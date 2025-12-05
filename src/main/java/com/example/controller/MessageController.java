package com.example.controller;

import com.example.dto.MessageRequest;
import com.example.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private KafkaProducerService service;

    @GetMapping("/check")
    public ResponseEntity<String> checkHealth(){
        return ResponseEntity.ok("Kafka server is Running...");
    }

    @PostMapping("/sendmessage")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest request){
        String messageId = UUID.randomUUID().toString();
        service.sendMessage(messageId, request.getMessageContent(),request.getSender());
        return  ResponseEntity.ok("Message Send with Id: "+messageId);
    }
}
