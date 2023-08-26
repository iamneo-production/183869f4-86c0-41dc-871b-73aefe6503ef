package com.prasadani.notificationservice.service;

import java.util.List;

import com.prasadani.notificationservice.dto.NotificationDto;

public interface NotificationService {

    NotificationDto createNotification(NotificationDto notificationDto);

    List<NotificationDto> getNotifications();

    
}
