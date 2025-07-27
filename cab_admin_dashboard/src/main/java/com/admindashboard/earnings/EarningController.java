package com.admindashboard.earnings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/earnings")
public class EarningController {

    @Autowired
    private EarningService earningService;

    @GetMapping
    public List<Earning> getAllEarnings() {
        return earningService.getAllEarnings();
    }

    @GetMapping("/range")
    public ResponseEntity<Double> getEarningsInRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        
        List<Earning> earnings = earningService.getEarningsBetween(start, end);
        Double total = earningService.calculateTotalEarnings(earnings);
        return ResponseEntity.ok(total);
    }
}
