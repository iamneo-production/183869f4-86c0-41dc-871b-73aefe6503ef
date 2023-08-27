package com.bfsi.rulesservice.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.rulesservice.dto.NotificationDto;
import com.bfsi.rulesservice.dto.TransactionDto;
import com.bfsi.rulesservice.producer.NotificationProducer;
import com.bfsi.rulesservice.service.DecisionService;

@Service
public class DecisionServiceImpl implements DecisionService{

	@Autowired
	KieContainer kieContainer;

	@Autowired
	NotificationProducer notificationProducer;

	@Override
	public TransactionDto checkTransactionFraud(TransactionDto transactionDto) {
		
		KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(transactionDto);
        kieSession.fireAllRules();
        kieSession.dispose();

		if(transactionDto.isFraud()){
			NotificationDto notificationDto = NotificationDto.builder()
					.customer_id(transactionDto.getCustomer_id())
					.amount(transactionDto.getAmount())
					.date(transactionDto.getDate())
					.trans_id(transactionDto.getId())
					.trans_type(transactionDto.getTrans_type())
					.notificationType("role-trigger-detection")
					.build();
					
			notificationProducer.sendMessage(notificationDto);
		}

        return transactionDto;
		
	}
    
}
