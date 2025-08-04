package com.admindashboard.earnings;

import com.admindashboard.driververification.Driver;
import com.admindashboard.driververification.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarningService {

    @Autowired
    private EarningRepository earningRepository;

    @Autowired
    private DriverRepository driverRepository;

    public List<Earning> getAllEarnings() {
        return earningRepository.findAll();
    }

    public List<Earning> getEarningsByDriverId(Integer driverId) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found with id " + driverId));
        return earningRepository.findByDriver(driver);
    }

    public Earning addEarning(Earning earning) {
        return earningRepository.save(earning);
    }

    public void deleteEarning(Integer id) {
        earningRepository.deleteById(id);
    }
}
