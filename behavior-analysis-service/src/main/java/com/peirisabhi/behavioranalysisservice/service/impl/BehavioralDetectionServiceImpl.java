package com.peirisabhi.behavioranalysisservice.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peirisabhi.behavioranalysisservice.dto.BehavioralDetectionDto;
import com.peirisabhi.behavioranalysisservice.dto.NotificationDto;
import com.peirisabhi.behavioranalysisservice.dto.TransactionDto;
import com.peirisabhi.behavioranalysisservice.entity.BehavioralDetection;
import com.peirisabhi.behavioranalysisservice.producer.NotificationProducer;
import com.peirisabhi.behavioranalysisservice.repository.BehavioralDetectionRepository;
import com.peirisabhi.behavioranalysisservice.service.BehavioralDetectionService;

@Service
public class BehavioralDetectionServiceImpl implements BehavioralDetectionService {

	@Autowired
	NotificationProducer notificationProducer;

	@Autowired
	BehavioralDetectionRepository behavioralDetectionRepository;

	@Override
	public BehavioralDetectionDto checkTransaction(TransactionDto transactionDto) {

		BehavioralDetectionDto behavioralDetectionDto = null;

		if (true) {

			BehavioralDetection behavioralDetection = new BehavioralDetection();
			behavioralDetection.setCustomer_id(transactionDto.getCustomer_id());
			behavioralDetection.setAmount(transactionDto.getAmount());
			behavioralDetection.setCreatedAt(new Date());
			behavioralDetection.setTrans_type(transactionDto.getTrans_type());
			behavioralDetection.setDate(new Date());
			behavioralDetection.setDetectedBehavior("GEO");

			behavioralDetectionDto = behavioralDetectionRepository.save(behavioralDetection)
					.toDto(BehavioralDetectionDto.class);

			NotificationDto notificationDto = NotificationDto.builder()
					.customer_id(transactionDto.getCustomer_id())
					.amount(transactionDto.getAmount())
					.date(transactionDto.getDate())
					.trans_id(transactionDto.getId())
					.trans_type(transactionDto.getTrans_type())
					.notificationType("invalid-behavior-detection")
					.build();

			notificationProducer.sendMessage(notificationDto);
		}

		return behavioralDetectionDto;
	}

	@Override
	public List<BehavioralDetectionDto> getAllBehaviroalDetections() {

		List<BehavioralDetectionDto> behavioralDetections = behavioralDetectionRepository.findAll()
				.stream()
				.map(d -> d.toDto(BehavioralDetectionDto.class))
				.collect(Collectors.toList());

		return behavioralDetections;
	}

}
