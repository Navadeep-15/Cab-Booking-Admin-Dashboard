package com.admindashboard.driververification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public List<Driver> getPendingDrivers() {
        return driverRepository.findByStatus("pending");
    }

    public Driver approveDriver(Long driverId) {
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if (optionalDriver.isPresent()) {
            Driver driver = optionalDriver.get();
            driver.setStatus("approved");
            return driverRepository.save(driver);
        }
        throw new RuntimeException("Driver not found");
    }

    public Driver rejectDriver(Long driverId) {
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if (optionalDriver.isPresent()) {
            Driver driver = optionalDriver.get();
            driver.setStatus("rejected");
            return driverRepository.save(driver);
        }
        throw new RuntimeException("Driver not found");
    }
}
