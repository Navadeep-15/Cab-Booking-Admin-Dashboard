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
        return rideLogService.getAllRideLogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RideLog> getRideById(@PathVariable Long id) {
        return ResponseEntity.ok(rideLogService.getRideLogById(id));
    }

    @GetMapping("/cancelled")
    public List<RideLog> getCancelledRides() {
        return rideLogService.getCancelledRides();
    }

    @GetMapping("/complaints")
    public List<RideLog> getComplaints() {
        return rideLogService.getComplaints();
    }

    @PostMapping
    public ResponseEntity<RideLog> addRide(@RequestBody RideLog rideLog) {
        return ResponseEntity.ok(rideLogService.addRideLog(rideLog));
    }
}
