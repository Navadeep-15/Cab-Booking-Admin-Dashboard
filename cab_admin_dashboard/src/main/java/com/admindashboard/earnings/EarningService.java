package com.admindashboard.earnings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarningService {

    @Autowired
    private EarningRepository earningRepository;

    public List<Earning> getAllEarnings() {
        return earningRepository.findAll();
    }

    public Earning getEarningById(Long id) {
        return earningRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Earning not found with ID: " + id));
    }

    public Earning createEarning(Earning earning) {
        return earningRepository.save(earning);
    }

    public Earning updateEarning(Long id, Earning updatedEarning) {
        Earning earning = getEarningById(id);
        earning.setRideId(updatedEarning.getRideId());
        earning.setUserId(updatedEarning.getUserId());
        earning.setDriverId(updatedEarning.getDriverId());
        earning.setAmount(updatedEarning.getAmount());
        earning.setPaymentMethod(updatedEarning.getPaymentMethod());
        earning.setPaymentStatus(updatedEarning.getPaymentStatus());
        earning.setPaymentDate(updatedEarning.getPaymentDate());
        return earningRepository.save(earning);
    }

    public void deleteEarning(Long id) {
        earningRepository.deleteById(id);
    }
}
