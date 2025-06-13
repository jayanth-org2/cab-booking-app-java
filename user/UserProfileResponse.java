package com.uberclone.dto.user;

import lombok.Data;

@Data
public class UserProfileResponse {
    private Long id;
    private String name;
    private String email;
    private String role;
    private double rating;
    private int totalRides;
} 