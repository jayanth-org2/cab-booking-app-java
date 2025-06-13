package com.uberclone.cab.controller;

import com.uberclone.cab.dto.CabRegistrationRequest;
import com.uberclone.cab.dto.CabResponse;
import com.uberclone.cab.service.CabService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cabs")
@RequiredArgsConstructor
@Tag(name = "Cab", description = "Cab management APIs")
public class CabController {

    private final CabService cabService;

    @PostMapping("/register")
    @PreAuthorize("hasRole('DRIVER')")
    @Operation(summary = "Register a new cab")
    public ResponseEntity<CabResponse> registerCab(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody CabRegistrationRequest request) {
        return ResponseEntity.ok(cabService.registerCab(userDetails.getUsername(), request));
    }

    @GetMapping("/assigned")
    @PreAuthorize("hasRole('DRIVER')")
    @Operation(summary = "Get assigned cab details")
    public ResponseEntity<CabResponse> getAssignedCab(
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(cabService.getAssignedCab(userDetails.getUsername()));
    }

    @PutMapping("/{cabId}/status")
    @PreAuthorize("hasRole('DRIVER')")
    @Operation(summary = "Update cab status")
    public ResponseEntity<CabResponse> updateCabStatus(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long cabId,
            @RequestParam String status) {
        return ResponseEntity.ok(cabService.updateCabStatus(userDetails.getUsername(), cabId, status));
    }
} 