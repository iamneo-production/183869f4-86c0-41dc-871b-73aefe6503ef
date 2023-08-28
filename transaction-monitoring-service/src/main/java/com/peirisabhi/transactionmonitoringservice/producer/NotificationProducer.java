package com.peirisabhi.transactionmonitoringservice.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.peirisabhi.transactionmonitoringservice.dto.NotificationDto;
import com.peirisabhi.transactionmonitoringservice.dto.TransactionDto;

@Component
public class NotificationProducer {
    
    @Value("${spring.kafka.topic-notification.name}")
    private String topicNotificationName;

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationProducer.class);

    // @Autowired
    private KafkaTemplate<String, NotificationDto> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, NotificationDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(NotificationDto data){
        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<NotificationDto> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicNotificationName)
                .build();

        kafkaTemplate.send(message);
    }
}
