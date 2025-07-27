package com.admindashboard.earnings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EarningService {

    @Autowired
    private EarningRepository earningRepository;

    public List<Earning> getAllEarnings() {
        return earningRepository.findAll();
    }

    public List<Earning> getEarningsBetween(LocalDateTime start, LocalDateTime end) {
        return earningRepository.findByPayment_timeBetween(start, end);
    }

    public Double calculateTotalEarnings(List<Earning> earnings) {
        return earnings.stream().mapToDouble(Earning::getAmount).sum();
    }
}
