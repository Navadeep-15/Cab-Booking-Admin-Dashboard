package com.admindashboard.ridelogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideLogService {

    @Autowired
    private RideLogRepository rideLogRepository;

    public List<RideLog> getAllRideLogs() {
        return rideLogRepository.findAll();
    }

    public RideLog getRideLogById(Long id) {
        return rideLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found with ID: " + id));
    }

    public List<RideLog> getCancelledRides() {
        return rideLogRepository.findByStatus("cancelled");
    }

    public List<RideLog> getComplaints() {
        return rideLogRepository.findByComplaintIsNotNull();
    }

    public RideLog addRideLog(RideLog rideLog) {
        return rideLogRepository.save(rideLog);
    }
}
