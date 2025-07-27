package com.admindashboard.ridelogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ridelogs")
public class RideLogController {

    @Autowired
    private RideLogService rideLogService;

    @GetMapping
    public List<RideLog> getAllRides() {
        return rideLogService.getAllRides();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RideLog> getRideById(@PathVariable Long id) {
        RideLog ride = rideLogService.getRideById(id);
        return ride != null ? ResponseEntity.ok(ride) : ResponseEntity.notFound().build();
    }

    @GetMapping("/cancelled")
    public List<RideLog> getCancelledRides() {
        return rideLogService.getCancelledRides();
    }

    @GetMapping("/complaints")
    public List<RideLog> getComplaints() {
        return rideLogService.getComplaints();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RideLog> updateRide(@PathVariable Long id, @RequestBody RideLog ride) {
        RideLog updated = rideLogService.updateRide(id, ride);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRide(@PathVariable Long id) {
        rideLogService.deleteRide(id);
        return ResponseEntity.noContent().build();
    }
}
