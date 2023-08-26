package com.peirisabhi.transactionmonitoringservice.dto;

import lombok.Data;

@Data
public class NotificationDto {
    
    private int id;

    private int customer_id;

    private int trans_id;

    private String trans_type;

    private String date;

    private double amount;

}
