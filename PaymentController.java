package com.uberclone.payment.controller;

import com.uberclone.payment.model.Payment;
import com.uberclone.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/bookings/{bookingId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Payment> processPayment(
            @PathVariable Long bookingId,
            @RequestParam String paymentMethod) {
        Payment payment = paymentService.processPayment(bookingId, paymentMethod);
        return ResponseEntity.ok(payment);
    }

    @PostMapping("/{paymentId}/refund")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Payment> refundPayment(@PathVariable Long paymentId) {
        Payment payment = paymentService.refundPayment(paymentId);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/{paymentId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Payment> getPayment(@PathVariable Long paymentId) {
        Payment payment = paymentService.getPayment(paymentId);
        return ResponseEntity.ok(payment);
    }
} 