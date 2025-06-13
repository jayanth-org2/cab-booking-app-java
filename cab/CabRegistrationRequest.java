package com.uberclone.dto.cab;

import com.uberclone.model.Cab;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CabRegistrationRequest {
    @NotBlank(message = "License plate is required")
    private String licensePlate;

    @NotNull(message = "Cab type is required")
    private Cab.Type type;
} 