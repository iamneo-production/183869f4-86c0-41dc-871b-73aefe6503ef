package com.peirisabhi.behavioranalysisservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.peirisabhi.behavioranalysisservice.util.Transformer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BehavioralDetection implements Transformer{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int customer_id;

    private String trans_type;

    private Date date;

    private double amount;

    private String detectedBehavior;

    private Date createdAt;

}
