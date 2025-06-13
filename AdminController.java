package com.uberclone.admin.controller;

import com.uberclone.admin.dto.DriverVerificationRequest;
import com.uberclone.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
@Tag(name = "Admin", description = "Admin management APIs")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    @Operation(summary = "Get all users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/drivers")
    @Operation(summary = "Get all drivers")
    public ResponseEntity<List<DriverResponse>> getAllDrivers() {
        return ResponseEntity.ok(adminService.getAllDrivers());
    }

    @GetMapping("/bookings")
    @Operation(summary = "Get all bookings")
    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        return ResponseEntity.ok(adminService.getAllBookings());
    }

    @GetMapping("/payments")
    @Operation(summary = "Get all payments")
    public ResponseEntity<List<PaymentResponse>> getAllPayments() {
        return ResponseEntity.ok(adminService.getAllPayments());
    }

    @PutMapping("/drivers/{id}/verify")
    @Operation(summary = "Verify a driver")
    public ResponseEntity<DriverResponse> verifyDriver(
            @PathVariable Long id,
            @Valid @RequestBody DriverVerificationRequest request) {
        return ResponseEntity.ok(adminService.verifyDriver(id, request));
    }

    @PutMapping("/drivers/{id}/suspend")
    @Operation(summary = "Suspend a driver")
    public ResponseEntity<DriverResponse> suspendDriver(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.suspendDriver(id));
    }

    @PutMapping("/drivers/{id}/activate")
    @Operation(summary = "Activate a suspended driver")
    public ResponseEntity<DriverResponse> activateDriver(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.activateDriver(id));
    }

    @GetMapping("/dashboard/stats")
    @Operation(summary = "Get dashboard statistics")
    public ResponseEntity<DashboardStats> getDashboardStats() {
        return ResponseEntity.ok(adminService.getDashboardStats());
    }
} 