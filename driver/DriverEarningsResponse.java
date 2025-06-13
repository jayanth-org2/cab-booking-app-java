package com.uberclone.dto.driver;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DriverEarningsResponse {
    private double totalEarnings;
    private int totalRides;
    private double averageRating;
    private double todayEarnings;
    private int todayRides;
    private LocalDateTime lastRideTime;
} 