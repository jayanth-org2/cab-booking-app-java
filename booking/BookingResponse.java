package com.uberclone.booking.dto;

import com.uberclone.booking.model.Booking;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingResponse {
    private Long id;
    private String pickup;
    private String drop;
    private Booking.Status status;
    private Double fare;
    private LocalDateTime scheduledTime;
    private LocalDateTime createdAt;
    private String driverName;
    private String driverPhone;
    private String cabType;
    private String cabLicensePlate;
    private String estimatedArrivalTime;
    private String currentLocation;
} 