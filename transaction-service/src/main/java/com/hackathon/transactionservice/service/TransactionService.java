package com.hackathon.transactionservice.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.transactionservice.dto.TransactionDto;
import com.hackathon.transactionservice.model.Transaction;
import com.hackathon.transactionservice.repository.TransactionRepository;

@Service
public class TransactionService {

    double SenderBalance = 500000.00;
    double ReceiverBalance = 45000.00;

    @Autowired
    private TransactionRepository transactionRepository;


    // public Transaction transferAmount(TransactionDto transactionDto){

    //     LocalDateTime currentDateTime = LocalDateTime.now();
    //     Transaction transaction = Transaction.builder()
    //             .customer_id(transactionDto.getCustomer_id())
    //             .trans_type(transactionDto.getTrans_type())
    //             .date(currentDateTime)
    //             .amount(transactionDto.getAmount())
    //             .created_at(LocalDateTime.now())
    //             .build();
    //     creditDebitAmount(transactionDto.getAmount());
    //     transactionRepository.save(transaction);
        
    //     return transaction;
    // }



    public TransactionDto transferAmount(TransactionDto transactionDto){

        LocalDateTime currentDateTime = LocalDateTime.now();
        Transaction transaction = transactionDto.toEntity(Transaction.class);
        transaction.setDate(currentDateTime);
        transaction.setCreated_at(LocalDateTime.now());
        return transactionRepository.save(transaction).toDto(TransactionDto.class);
    
    }

    public TransactionDto getByCustomerID(int customerId) {
		return transactionRepository.findByCustomerId(customerId).orElse(null)
        .toDto(TransactionDto.class);
	}

    public void creditDebitAmount(double amount){
        SenderBalance = SenderBalance - amount;
        ReceiverBalance = ReceiverBalance + amount;
        System.out.println("Sender : "+SenderBalance+ " ,Receiver : " + ReceiverBalance);
    }

}