package com.peirisabhi.transactionmonitoringservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peirisabhi.transactionmonitoringservice.dto.NotificationDto;
import com.peirisabhi.transactionmonitoringservice.dto.TransactionDto;
import com.peirisabhi.transactionmonitoringservice.producer.NotificationProducer;
import com.peirisabhi.transactionmonitoringservice.service.TransactionMonitoringService;

@Service
public class TransactionMonitoringServiceImpl implements TransactionMonitoringService{

    @Autowired
    NotificationProducer notificationProducer;

    @Override
    public boolean isSuspicious(TransactionDto transactionDto) {
        boolean suspicious = true;

        // Check is this transaction Suspicious


        if(suspicious){

            NotificationDto notificationDto = NotificationDto.builder()
            .customer_id(transactionDto.getCustomer_id())
            .amount(transactionDto.getAmount())
            .date(transactionDto.getDate())
            .trans_id(transactionDto.getId())
            .trans_type(transactionDto.getTrans_type())
            .notificationType("suspicious")
            .build();

            notificationProducer.sendMessage(notificationDto);
        }
        
        return suspicious;
    }
    
}
