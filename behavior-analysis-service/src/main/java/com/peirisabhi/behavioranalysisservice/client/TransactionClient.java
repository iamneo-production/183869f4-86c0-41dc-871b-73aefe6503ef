package com.peirisabhi.behavioranalysisservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.peirisabhi.behavioranalysisservice.dto.TransactionDto;

import io.github.resilience4j.retry.annotation.Retry;

import java.util.List;

@FeignClient(name = "TRANSACTION-SERVICE")
public interface TransactionClient {

    @Retry(fallbackMethod = "getAllTransactions", name = "behavior-analysis-service")
    @GetMapping("/api/v1/transaction/{customerId}")
    List<TransactionDto> getTransactionByCustomer(@PathVariable("customerId") String customerId);

    @GetMapping("/api/v1/transaction/")
    List<TransactionDto> getTransactions();

}
