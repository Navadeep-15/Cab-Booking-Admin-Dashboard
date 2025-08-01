package com.admindashboard.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class AdminLogController {

    @Autowired
    private AdminLogService adminLogService;

    @GetMapping
    public List<AdminLog> getAllLogs() {
        return adminLogService.getAllLogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminLog> getLogById(@PathVariable Long id) {
        AdminLog log = adminLogService.getLogById(id);
        return log != null ? ResponseEntity.ok(log) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AdminLog> createLog(@RequestBody AdminLog log) {
        return ResponseEntity.ok(adminLogService.saveLog(log));
    }
}
