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
        return ResponseEntity.ok(earningService.getEarningById(id));
    }

    @PostMapping
    public ResponseEntity<Earning> createEarning(@RequestBody Earning earning) {
        return ResponseEntity.ok(earningService.createEarning(earning));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Earning> updateEarning(@PathVariable Long id, @RequestBody Earning earning) {
        return ResponseEntity.ok(earningService.updateEarning(id, earning));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEarning(@PathVariable Long id) {
        earningService.deleteEarning(id);
        return ResponseEntity.noContent().build();
    }
}
