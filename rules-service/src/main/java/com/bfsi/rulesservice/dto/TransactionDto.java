package com.bfsi.rulesservice.dto;

import lombok.Data;

@Data
public class TransactionDto {
    private int id;

    private int customer_id;

    private String trans_type;

    private String date;

    private Double amount;

    private String currency;

    private String created_at;

    private boolean fraud;
}
