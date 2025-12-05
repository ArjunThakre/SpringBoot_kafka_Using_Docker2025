package com.example.service;

import com.example.dto.MessageRequest;
import com.example.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    private static final Logger logger=LoggerFactory.getLogger(KafkaProducerService.class);
    private static final String TOPIC="driver-location";

    @Autowired
    private KafkaTemplate<String, Object>kafkaTemplate;

    public void sendMessage(Message message){
        logger.info("Sending message to TOPIC"+TOPIC);
       CompletableFuture<SendResult<String,Object>> future= kafkaTemplate.send(TOPIC, message.getId(),message);
      future.whenComplete((result,exception)->{
          if (exception!=null){
              logger.error("Failed to Send the message"+exception.getMessage());
          }
          else {
              logger.info("Message Send with offset"+ result.getRecordMetadata().offset());
          }
      });
    }

    public void sendMessage(String messageId, String messageContent, String sender) {
        Message message=new Message(messageId,messageContent,sender);
        sendMessage(message);
    }
}
