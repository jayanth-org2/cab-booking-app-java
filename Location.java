package com.uberclone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;

    @Column
    private String postalCode;

    @Column
    private String formattedAddress;

    @Column
    private Boolean isActive = true;
} 