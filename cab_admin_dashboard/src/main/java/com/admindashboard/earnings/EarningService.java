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
        return earningRepository.findById(id).orElse(null);
    }
}
