package com.peirisabhi.transactionmonitoringservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peirisabhi.transactionmonitoringservice.dto.TransactionDto;
import com.peirisabhi.transactionmonitoringservice.service.TransactionMonitoringService;

@Component
public class TransactionConsumer {

    @Autowired
    TransactionMonitoringService transactionMonitoringService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionConsumer.class);

    // @KafkaListener(topics = "${spring.kafka.topic-transactions.name}", groupId = "${spring.kafka.consumer.group-id}")
    @KafkaListener(topics = "${spring.kafka.topic-transactions.name}")
    public void consume(String message) {
        LOGGER.info(String.format("Message received -> %s", message));
        // System.out.println(message);

        ObjectMapper mapper = new ObjectMapper();
        try {
            TransactionDto transactionDto = mapper.readValue(message, TransactionDto.class);
            // System.out.println(transactionDto);

            transactionMonitoringService.isSuspicious(transactionDto);

        } catch (JsonProcessingException e) {
            
            e.printStackTrace();
        }
    }


}
