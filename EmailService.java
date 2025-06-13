package com.uberclone.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    public void sendPasswordResetEmail(String to, String otp) {
        // Mock implementation - in real app, would use JavaMailSender
        System.out.println("Sending password reset email to: " + to);
        System.out.println("OTP: " + otp);
    }
} 