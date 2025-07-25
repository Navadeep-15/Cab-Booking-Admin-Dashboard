package com.admindashboard.driververification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Driver approveDriver(Long id) {
        Driver driver = driverRepository.findById(id).orElse(null);
        if (driver != null) {
            driver.setStatus("approved");
            return driverRepository.save(driver);
        }
        return null;
    }

    public Driver rejectDriver(Long id) {
        Driver driver = driverRepository.findById(id).orElse(null);
        if (driver != null) {
            driver.setStatus("rejected");
            return driverRepository.save(driver);
        }
        return null;
    }
}
