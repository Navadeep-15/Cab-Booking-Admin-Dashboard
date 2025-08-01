package com.admindashboard.ridelogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
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
}
