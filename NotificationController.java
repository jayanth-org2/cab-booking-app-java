package com.uberclone.notification.controller;

import com.uberclone.notification.model.Notification;
import com.uberclone.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Notification>> getUserNotifications() {
        // TODO: Get current user ID from security context
        Long userId = 1L; // Placeholder
        List<Notification> notifications = notificationService.getUserNotifications(userId);
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/unread")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Notification>> getUnreadNotifications() {
        // TODO: Get current user ID from security context
        Long userId = 1L; // Placeholder
        List<Notification> notifications = notificationService.getUnreadNotifications(userId);
        return ResponseEntity.ok(notifications);
    }

    @PostMapping("/{notificationId}/read")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> markAsRead(@PathVariable Long notificationId) {
        notificationService.markAsRead(notificationId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/read-all")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> markAllAsRead() {
        // TODO: Get current user ID from security context
        Long userId = 1L; // Placeholder
        notificationService.markAllAsRead(userId);
        return ResponseEntity.ok().build();
    }
} 