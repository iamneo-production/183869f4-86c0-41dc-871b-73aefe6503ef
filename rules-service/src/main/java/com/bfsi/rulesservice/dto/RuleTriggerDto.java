package com.bfsi.rulesservice.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RuleTriggerDto {
    private int id;

    private int customer_id;

    private String trans_type;

    private String date;

    private double amount;

    private String detectedRule;

    private String createdAt;
}
