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

    public Driver getDriverById(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + id));
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver updateDriver(Long id, Driver updatedDriver) {
        Driver driver = getDriverById(id);
        driver.setName(updatedDriver.getName());
        driver.setPhoneNumber(updatedDriver.getPhoneNumber());
        driver.setLicenseNumber(updatedDriver.getLicenseNumber());
        driver.setVehicleNumber(updatedDriver.getVehicleNumber());
        driver.setVehicleType(updatedDriver.getVehicleType());
        driver.setStatus(updatedDriver.getStatus());
        return driverRepository.save(driver);
    }

    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
}
