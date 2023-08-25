package com.hackathon.transactionservice.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.transactionservice.dto.TransactionDto;
import com.hackathon.transactionservice.model.Transaction;
import com.hackathon.transactionservice.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    public Transaction transferAmount(TransactionDto transactionDto){

        LocalDateTime currentDateTime = LocalDateTime.now();
        Transaction transaction = Transaction.builder()
                .customer_id(transactionDto.getCustomer_id())
                .trans_type(transactionDto.getTrans_type())
                .date(currentDateTime)
                .amount(transactionDto.getAmount())
                .currency(transactionDto.getCurrency())
                .created_at(currentDateTime)
                .build();

        transactionRepository.save(transaction);

        return transaction;
    }


}