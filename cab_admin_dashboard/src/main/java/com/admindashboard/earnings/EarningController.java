package com.admindashboard.earnings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Earning> getEarningById(@PathVariable Long id) {
        Earning earning = earningService.getEarningById(id);
        return earning != null ? ResponseEntity.ok(earning) : ResponseEntity.notFound().build();
    }
}
