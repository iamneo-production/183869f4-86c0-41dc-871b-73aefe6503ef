package com.prasadani.notificationservice.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prasadani.notificationservice.dto.NotificationDto;
import com.prasadani.notificationservice.service.NotificationService;




@Component
public class NotificationConsumer {

    @Autowired
    NotificationService notificationService;
    
private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);

// @KafkaListener(topics = "${spring.kafka.topic-notification.name}", groupId = "${spring.kafka.consumer.group-id}")
    @KafkaListener(topics = "${spring.kafka.topic-notification.name}")
    public void consume(String message) {
        LOGGER.info(String.format("Message received -> %s", message));
        //System.out.println(message);

        ObjectMapper mapper = new ObjectMapper();
        try {
            NotificationDto notificationDto = mapper.readValue(message, NotificationDto.class);
            //System.out.println(notificationDto);
            notificationService.createNotification(notificationDto);
        } catch (JsonProcessingException e) {
            
            e.printStackTrace();
        }
    }

}
