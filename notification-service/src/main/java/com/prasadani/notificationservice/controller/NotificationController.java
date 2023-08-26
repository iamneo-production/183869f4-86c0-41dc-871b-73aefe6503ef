package com.prasadani.notificationservice.controller;

import java.util.List;

// import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prasadani.notificationservice.dto.NotificationDto;
import com.prasadani.notificationservice.service.NotificationService;

@RestController
@RequestMapping("api/notification")

public class NotificationController {

@Autowired
NotificationService notificationService;


@PostMapping()
public ResponseEntity<NotificationDto> createNotification(@RequestBody NotificationDto notificationDto){
    System.out.println(notificationDto.toString());
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(notificationService.createNotification(notificationDto));
}

@GetMapping()
    public ResponseEntity<List<NotificationDto>> getNotifications() {
        return ResponseEntity.ok(notificationService.getNotifications());
    }

}
   

