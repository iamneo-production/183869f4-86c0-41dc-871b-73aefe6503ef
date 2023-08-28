package com.prasadani.notificationservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {

    private int id;

    private int customer_id;

    private int trans_id;

    private String trans_type;

    private String date;

    private double amount;

    private String notificationType;
  
}
