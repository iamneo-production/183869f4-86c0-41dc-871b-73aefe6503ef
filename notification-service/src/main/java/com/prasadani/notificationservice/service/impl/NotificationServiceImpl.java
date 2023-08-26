package com.prasadani.notificationservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasadani.notificationservice.dto.NotificationDto;
import com.prasadani.notificationservice.model.Notification;
import com.prasadani.notificationservice.repository.NotificationRepository;
import com.prasadani.notificationservice.service.NotificationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService{



    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {

        log.info("Data {}", notificationDto);


        Notification notification = new Notification();
        notification.setCoustomer_id(notificationDto.getCoustomer_id());
        notification.setTrans_id(notificationDto.getTrans_id());
        notification.setDate(notificationDto.getDate());
        notification.setAmount(notificationDto.getAmount());
        notification.setCreated_at(notificationDto.getCreated_at());
        notification.setNotification_type(notificationDto.getNotification_type());

        log.info("Data Last {}", notification);

        Notification savedNotification = notificationRepository.save(notification);
        return convertToDto(savedNotification);

    }

    @Override
    public List<NotificationDto> getNotifications() {
        List<Notification> notifications = notificationRepository.findAll();
        return notifications.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private NotificationDto convertToDto(Notification notification) {
        NotificationDto dto = new NotificationDto();
        dto.setId(notification.getId());
        dto.setCoustomer_id(notification.getCoustomer_id());
        dto.setTrans_id(notification.getTrans_id());
        dto.setDate(notification.getDate());
        dto.setAmount(notification.getAmount());
        dto.setCreated_at(notification.getCreated_at());
        dto.setNotification_type(notification.getNotification_type());
        return dto;
    }
}
