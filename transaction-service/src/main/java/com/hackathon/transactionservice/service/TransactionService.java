package com.hackathon.transactionservice.service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.transactionservice.dto.TransactionDto;
import com.hackathon.transactionservice.model.Transaction;
import com.hackathon.transactionservice.producer.TransactionProducer;
import com.hackathon.transactionservice.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    double SenderBalance = 500000.00;
    double ReceiverBalance = 45000.00;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    TransactionProducer transactionProducer;


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



    public TransactionDto saveTransaction(TransactionDto transactionDto){

        LocalDateTime currentDateTime = LocalDateTime.now();
        Transaction transaction = transactionDto.toEntity(Transaction.class);
        transaction.setDate(currentDateTime);
        transaction.setCreated_at(LocalDateTime.now());

        transactionProducer.sendMessage(transactionDto);

        return transactionRepository.save(transaction).toDto(TransactionDto.class);
    
    }

    public List<TransactionDto> getByCustomerID(int customerId) {
		 return transactionRepository.findAll().stream()
        .filter(transaction -> transaction.getCustomer_id() == customerId)
        .map(transaction -> transaction.toDto(TransactionDto.class))
        .collect(Collectors.toList());
       
	}

    public List<TransactionDto> getCustomers() {
		
        return transactionRepository.findAll()
        .stream()
        .map(transaction -> transaction.toDto(TransactionDto.class))
        .collect(Collectors.toList());
	}

    public void creditDebitAmount(double amount){
        SenderBalance = SenderBalance - amount;
        ReceiverBalance = ReceiverBalance + amount;
        System.out.println("Sender : "+SenderBalance+ " ,Receiver : " + ReceiverBalance);
    }

}