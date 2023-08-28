package com.peirisabhi.behavioranalysisservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.peirisabhi.behavioranalysisservice.client.TransactionClient;
import com.peirisabhi.behavioranalysisservice.dto.TransactionDto;

@RestController
@RequestMapping("api/behaviroal-analys")
public class BehavioralDetectionController {
 
    @Autowired
    TransactionClient transactionClient;


    @GetMapping()
    public List<TransactionDto> getTransactions(){
       return transactionClient.getTransactions();
    }
    
    
}
