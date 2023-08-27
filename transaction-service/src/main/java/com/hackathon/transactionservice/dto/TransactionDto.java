package com.hackathon.transactionservice.dto;

import java.time.LocalDateTime;

import com.hackathon.transactionservice.util.Transformer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto implements Transformer {

    private int id;

    private int customerId;

    private String trans_type;

    private LocalDateTime date;

    private double amount ;

    //private String currency;

    private LocalDateTime created_at;

             

}
