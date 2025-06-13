package com.uberclone.booking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingRequest {
    @NotBlank(message = "Pickup location is required")
    private String pickup;

    @NotBlank(message = "Drop location is required")
    private String drop;

    private LocalDateTime scheduledTime; // null for immediate booking
} 