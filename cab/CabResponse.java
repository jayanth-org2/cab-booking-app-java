package com.uberclone.dto.cab;

import com.uberclone.model.Cab;
import lombok.Data;

@Data
public class CabResponse {
    private Long id;
    private String licensePlate;
    private Cab.Type type;
    private Cab.Status status;
    private String driverName;
    private String driverEmail;
} 