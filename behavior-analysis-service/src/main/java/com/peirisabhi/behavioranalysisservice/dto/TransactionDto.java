package com.peirisabhi.behavioranalysisservice.dto;

import com.peirisabhi.behavioranalysisservice.util.Transformer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto implements Transformer{
    
    private int id;

    private int customer_id;

    private String trans_type;

    private String date;

    private double amount;

    private String created_at;

    private String zip_code;
}
