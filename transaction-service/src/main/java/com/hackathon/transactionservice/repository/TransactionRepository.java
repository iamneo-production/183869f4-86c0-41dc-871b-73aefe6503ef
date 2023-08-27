package com.hackathon.transactionservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


import com.hackathon.transactionservice.model.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    Optional<Transaction> findByCustomerId(int customerId);
}
