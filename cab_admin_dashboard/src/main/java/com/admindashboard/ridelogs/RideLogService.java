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

    public List<RideLog> getCancelledRides() {
        return rideLogRepository.findByStatus("cancelled");
    }

    public List<RideLog> getComplaints() {
        return rideLogRepository.findByComplaintIsNotNull();
    }

    public RideLog updateRide(Long id, RideLog ride) {
        RideLog existing = getRideById(id);
        if (existing != null) {
            existing.setStatus(ride.getStatus());
            existing.setFeedback(ride.getFeedback());
            existing.setComplaint(ride.getComplaint());
            return rideLogRepository.save(existing);
        }
        return null;
    }

    public void deleteRide(Long id) {
        rideLogRepository.deleteById(id);
    }
}
