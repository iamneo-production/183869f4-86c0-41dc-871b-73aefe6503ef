package com.prasadani.notificationservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {

    private int id;
    private int coustomer_id;
    private int trans_id;
    private String date;
    private double amount;
    private String created_at;
    private String notification_type;
  
}
