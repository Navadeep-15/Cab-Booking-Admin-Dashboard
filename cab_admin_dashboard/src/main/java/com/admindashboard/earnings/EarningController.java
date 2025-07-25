package com.admindashboard.earnings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/between")
    public List<Earning> getEarningsBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return earningService.getEarningsBetween(start, end);
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotalEarningsBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(earningService.getTotalEarningsBetween(start, end));
    }
}
