package com.admindashboard.driververification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/pending")
    public List<Driver> getPendingDrivers() {
        return driverService.getPendingDrivers();
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<Driver> approveDriver(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.approveDriver(id));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<Driver> rejectDriver(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.rejectDriver(id));
    }
}
