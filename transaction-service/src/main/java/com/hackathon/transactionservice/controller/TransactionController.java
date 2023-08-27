package com.hackathon.transactionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.transactionservice.dto.TransactionDto;
import com.hackathon.transactionservice.service.TransactionService;

@RestController
@RequestMapping(value = "/api/v1/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<TransactionDto> add(@RequestBody TransactionDto transactionDto){
       return ResponseEntity.ok(transactionService.transferAmount(transactionDto));
    } 

    @GetMapping("{customerID}")
    public ResponseEntity<TransactionDto> getByCustomerID(@PathVariable String customerID) {
        System.out.println(customerID);
        return ResponseEntity.ok(transactionService.getByCustomerID(customerID));
    }



}