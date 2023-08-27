package com.bfsi.rulesservice.service;

import com.bfsi.rulesservice.dto.TransactionRequest;

public interface DecisionService {
    
    TransactionRequest checkTransactionFraud(TransactionRequest transactionRequest);

}
