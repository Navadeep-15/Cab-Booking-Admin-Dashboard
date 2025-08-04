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

    @GetMapping("/driver/{driverId}")
    public List<Earning> getEarningsByDriver(@PathVariable Integer driverId) {
        return earningService.getEarningsByDriverId(driverId);
    }

    @PostMapping
    public ResponseEntity<Earning> addEarning(@RequestBody Earning earning) {
        return ResponseEntity.ok(earningService.addEarning(earning));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEarning(@PathVariable Integer id) {
        earningService.deleteEarning(id);
        return ResponseEntity.noContent().build();
    }
}
