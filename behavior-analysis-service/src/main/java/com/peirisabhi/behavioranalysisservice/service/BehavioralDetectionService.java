package com.peirisabhi.behavioranalysisservice.service;

import java.util.List;

import com.peirisabhi.behavioranalysisservice.dto.BehavioralDetectionDto;
import com.peirisabhi.behavioranalysisservice.dto.TransactionDto;

public interface BehavioralDetectionService {
    
    BehavioralDetectionDto checkTransaction(TransactionDto transactionDto);

    List<BehavioralDetectionDto> getAllBehaviroalDetections();
    
}
