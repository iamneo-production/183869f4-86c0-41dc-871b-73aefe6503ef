package com.hackathon.transactionservice.repository;

//import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.transactionservice.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    //List<Transaction> findByCustomer_id(int customerId);
}
