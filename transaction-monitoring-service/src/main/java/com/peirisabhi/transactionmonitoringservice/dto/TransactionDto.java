package com.peirisabhi.transactionmonitoringservice.dto;

import com.peirisabhi.transactionmonitoringservice.util.Transformer;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TransactionDto implements Transformer{

    private int id;

    private int customer_id;

    private String trans_type;

    private String date;

    private double amount;

    private String created_at;
}
