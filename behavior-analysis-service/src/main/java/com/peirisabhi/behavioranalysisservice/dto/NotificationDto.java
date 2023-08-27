package com.peirisabhi.behavioranalysisservice.dto;

import com.peirisabhi.behavioranalysisservice.util.Transformer;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class NotificationDto implements Transformer{

    private int id;

    private int customer_id;

    private int trans_id;

    private String trans_type;

    private String date;

    private double amount;

    private String notificationType;
}
