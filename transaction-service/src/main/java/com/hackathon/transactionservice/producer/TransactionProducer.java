package com.hackathon.transactionservice.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;

import com.hackathon.transactionservice.dto.TransactionDto;



@Component
public class TransactionProducer {
    @Value("${spring.kafka.topic-transactions.name}")
    private String topicTransactionName;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProducer.class);

    // @Autowired
    private KafkaTemplate<String, TransactionDto> kafkaTemplate;

    public TransactionProducer(KafkaTemplate<String, TransactionDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(TransactionDto data){
        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<TransactionDto> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicTransactionName)
                .build();

        kafkaTemplate.send(message);
    }
}
