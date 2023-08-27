package com.bfsi.rulesservice.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.rulesservice.dto.TransactionRequest;
import com.bfsi.rulesservice.service.DecisionService;

@Service
public class DecisionServiceImpl implements DecisionService{

	@Autowired
	KieContainer kieContainer;

	// @Autowired


	@Override
	public TransactionRequest checkTransactionFraud(TransactionRequest transactionRequest) {
		
		KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(transactionRequest);
        kieSession.fireAllRules();
        kieSession.dispose();

		if(transactionRequest.isFraud()){

		}

        return transactionRequest;
		
	}
    
}
