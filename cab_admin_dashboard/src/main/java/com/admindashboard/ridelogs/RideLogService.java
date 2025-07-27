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
        return rideLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found with ID: " + id));
    }

    public RideLog createRide(RideLog rideLog) {
        return rideLogRepository.save(rideLog);
    }

    public RideLog updateRide(Long id, RideLog updated) {
        RideLog ride = getRideById(id);
        ride.setPickupAddress(updated.getPickupAddress());
        ride.setPickupLatitude(updated.getPickupLatitude());
        ride.setPickupLongitude(updated.getPickupLongitude());
        ride.setDestinationAddress(updated.getDestinationAddress());
        ride.setDestinationLatitude(updated.getDestinationLatitude());
        ride.setDestinationLongitude(updated.getDestinationLongitude());
        ride.setStatus(updated.getStatus());
        ride.setDriverRating(updated.getDriverRating());
        ride.setDriverFeedback(updated.getDriverFeedback());
        ride.setCustomerFeedback(updated.getCustomerFeedback());
        ride.setActualFare(updated.getActualFare());
        ride.setEstimatedFare(updated.getEstimatedFare());
        ride.setEstimatedDistance(updated.getEstimatedDistance());
        ride.setEstimatedDuration(updated.getEstimatedDuration());
        ride.setRequestedAt(updated.getRequestedAt());
        ride.setStartedAt(updated.getStartedAt());
        ride.setCompletedAt(updated.getCompletedAt());
        ride.setCancelledAt(updated.getCancelledAt());
        ride.setCancellationReason(updated.getCancellationReason());
        return rideLogRepository.save(ride);
    }

    public void deleteRide(Long id) {
        rideLogRepository.deleteById(id);
    }
}
