package com.admindashboard.driververification;

import com.admindashboard.usermanagement.User;
import com.admindashboard.usermanagement.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(Integer id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
    }

    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver updateDriver(Integer id, Driver driverDetails) {
        Driver driver = getDriverById(id);
        driver.setLicenseNumber(driverDetails.getLicenseNumber());
        driver.setVehicleType(driverDetails.getVehicleType());
        driver.setLicenseExpiryDate(driverDetails.getLicenseExpiryDate());
        driver.setVerificationStatus(driverDetails.getVerificationStatus());
        return driverRepository.save(driver);
    }

    public void deleteDriver(Integer id) {
        driverRepository.deleteById(id);
    }

    public List<Driver> getDriversByVerificationStatus(String status) {
        return driverRepository.findByVerificationStatus(status);
    }
}
