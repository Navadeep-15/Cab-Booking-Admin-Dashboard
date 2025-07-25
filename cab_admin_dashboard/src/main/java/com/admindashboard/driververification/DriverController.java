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

    @PostMapping("/{id}/approve")
    public ResponseEntity<Driver> approveDriver(@PathVariable Long id) {
        Driver approved = driverService.approveDriver(id);
        return approved != null ? ResponseEntity.ok(approved) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<Driver> rejectDriver(@PathVariable Long id) {
        Driver rejected = driverService.rejectDriver(id);
        return rejected != null ? ResponseEntity.ok(rejected) : ResponseEntity.notFound().build();
    }
}
