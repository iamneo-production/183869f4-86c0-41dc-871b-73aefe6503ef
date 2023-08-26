package com.peirisabhi.behavioranalysisservice.dto;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BehavioralDetectionDto {
    
    private int id;

    private int customer_id;

    private String trans_type;

    private Date date;

    private double amount;

    private String detectedBehavior;

    private Date createdAt;

}
