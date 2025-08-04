package com.admindashboard.usermanagement;

import com.admindashboard.driververification.Driver;
import com.admindashboard.driververification.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DriverRepository driverRepository;

    public User createUser(User user) {
        if (user.getDriver() != null && user.getDriver().getDriverId() != null) {
            Driver driver = driverRepository.findById(user.getDriver().getDriverId())
                    .orElseThrow(() -> new RuntimeException("Driver not found"));
            user.setDriver(driver);
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
