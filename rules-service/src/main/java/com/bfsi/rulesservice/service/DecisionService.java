package com.bfsi.rulesservice.service;

import com.bfsi.rulesservice.dto.TransactionDto;

public interface DecisionService {
    
    TransactionDto checkTransactionFraud(TransactionDto transactionRequest);

}
