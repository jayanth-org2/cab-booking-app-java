package com.uberclone.service;

import com.uberclone.dto.cab.CabRegistrationRequest;
import com.uberclone.dto.cab.CabResponse;
import com.uberclone.model.Cab;
import com.uberclone.model.Driver;
import com.uberclone.model.User;
import com.uberclone.repository.CabRepository;
import com.uberclone.repository.DriverRepository;
import com.uberclone.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CabService {

    private final CabRepository cabRepository;
    private final DriverRepository driverRepository;
    private final UserRepository userRepository;

    public CabService(CabRepository cabRepository,
                     DriverRepository driverRepository,
                     UserRepository userRepository) {
        this.cabRepository = cabRepository;
        this.driverRepository = driverRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public CabResponse registerCab(String email, CabRegistrationRequest request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        Driver driver = driverRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        
        if (cabRepository.existsByLicensePlate(request.getLicensePlate())) {
            throw new RuntimeException("License plate already registered");
        }
        
        Cab cab = new Cab();
        cab.setDriver(driver);
        cab.setLicensePlate(request.getLicensePlate());
        cab.setType(request.getType());
        cab.setStatus(Cab.Status.UNAVAILABLE);
        
        cab = cabRepository.save(cab);
        return mapToResponse(cab);
    }

    public CabResponse getAssignedCab(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        Driver driver = driverRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        
        Cab cab = cabRepository.findByDriver(driver)
                .orElseThrow(() -> new RuntimeException("No cab assigned to driver"));
        
        return mapToResponse(cab);
    }

    private CabResponse mapToResponse(Cab cab) {
        CabResponse response = new CabResponse();
        response.setId(cab.getId());
        response.setLicensePlate(cab.getLicensePlate());
        response.setType(cab.getType());
        response.setStatus(cab.getStatus());
        response.setDriverName(cab.getDriver().getUser().getName());
        response.setDriverEmail(cab.getDriver().getUser().getEmail());
        return response;
    }
} 