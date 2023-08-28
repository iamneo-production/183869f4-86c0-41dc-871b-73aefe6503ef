package com.hackathon.transactionservice.dto;

import java.time.LocalDateTime;

import com.hackathon.transactionservice.util.Transformer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDto implements Transformer {

    private int id;

    private int customer_id;

    private String trans_type;

    private String date;

    private double amount ;

    //private String zip_code;

    private String created_at;

             

}
