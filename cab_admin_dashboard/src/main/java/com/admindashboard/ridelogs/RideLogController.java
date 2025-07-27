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
        return ResponseEntity.ok(rideLogService.getRideById(id));
    }

    @PostMapping
    public ResponseEntity<RideLog> createRide(@RequestBody RideLog rideLog) {
        return ResponseEntity.ok(rideLogService.createRide(rideLog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RideLog> updateRide(@PathVariable Long id, @RequestBody RideLog rideLog) {
        return ResponseEntity.ok(rideLogService.updateRide(id, rideLog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRide(@PathVariable Long id) {
        rideLogService.deleteRide(id);
        return ResponseEntity.noContent().build();
    }
}
