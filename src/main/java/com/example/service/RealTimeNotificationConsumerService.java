package com.example.service;

import com.example.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class RealTimeNotificationConsumerService {

    private static final Logger logger= LoggerFactory.getLogger(RealTimeNotificationConsumerService.class);

    @KafkaListener(
            topics = "driver-location",
            groupId = "demo-group"
    )

    public void listen(
            @Payload Message message,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset
    ){
        logger.info("Message received from topic: {}, partition:{}, offset: {}"+topic,partition,offset);
        logger.info("Message content"+message);

        try {
            processRealTimeNotification(message);
            logger.info("Message Process Succesfully..");
        }
        catch (Exception ex){
            logger.error("Message Processing Failed>>"+ex.getMessage());
        }
    }

    public void processRealTimeNotification(Message message){
        logger.info("Processing message"+message.getMessageContent());
        //Actual bissness logic
        try {
            Thread.sleep(100);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
            throw new RuntimeException("processing interrupted",ex);
        }
    }

}
