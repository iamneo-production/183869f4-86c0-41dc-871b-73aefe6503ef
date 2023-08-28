package com.bfsi.rulesservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.bfsi.rulesservice.dto.TransactionDto;
import com.bfsi.rulesservice.service.DecisionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TransactionConsumer {
    
private static final Logger LOGGER = LoggerFactory.getLogger(TransactionConsumer.class);

    @Autowired
    DecisionService decisionService;

    // @KafkaListener(topics = "${spring.kafka.topic-transactions.name}", groupId = "${spring.kafka.consumer.group-id}")
    @KafkaListener(topics = "${spring.kafka.topic-transactions.name}")
    public void consume(String message) {
        LOGGER.info(String.format("Message received -> %s", message));
        // System.out.println(message);

        ObjectMapper mapper = new ObjectMapper();
        try {
            TransactionDto transactionDto = mapper.readValue(message, TransactionDto.class);
            // System.out.println(transactionDto);
            decisionService.checkTransactionFraud(transactionDto);
            
        } catch (JsonProcessingException e) {
            
            e.printStackTrace();
        }
    }

}
