package com.admindashboard.ridelogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideLogService {

    @Autowired
    private RideLogRepository rideLogRepository;

    public List<RideLog> getAllRides() {
        return rideLogRepository.findAll();
    }

    public RideLog getRideById(Long id) {
        return rideLogRepository.findById(id).orElse(null);
    }
}
