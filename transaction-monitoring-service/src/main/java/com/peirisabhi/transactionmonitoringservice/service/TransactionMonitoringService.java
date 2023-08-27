package com.peirisabhi.transactionmonitoringservice.service;

import com.peirisabhi.transactionmonitoringservice.dto.TransactionDto;

public interface TransactionMonitoringService {
    
    boolean isSuspicious(TransactionDto transactionDto);

}
