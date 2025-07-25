package com.admindashboard.earnings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EarningService {

    @Autowired
    private EarningRepository earningRepository;

    public List<Earning> getAllEarnings() {
        return earningRepository.findAll();
    }

    public List<Earning> getEarningsBetween(LocalDate start, LocalDate end) {
        return earningRepository.findByDateBetween(start, end);
    }

    public Double getTotalEarningsBetween(LocalDate start, LocalDate end) {
        return earningRepository.findTotalEarningsBetween(start, end);
    }
}
