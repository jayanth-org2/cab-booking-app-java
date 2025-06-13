package com.uberclone.repository;

import com.uberclone.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CabRepository extends JpaRepository<Cab, Long> {
    boolean existsByLicensePlate(String licensePlate);
    Optional<Cab> findFirstByStatus(Cab.Status status);
} 