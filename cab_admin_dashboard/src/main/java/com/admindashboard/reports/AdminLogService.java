package com.admindashboard.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminLogService {

    @Autowired
    private AdminLogRepository adminLogRepository;

    public List<AdminLog> getAllLogs() {
        return adminLogRepository.findAll();
    }

    public AdminLog getLogById(Long id) {
        return adminLogRepository.findById(id).orElse(null);
    }

    public AdminLog saveLog(AdminLog log) {
        return adminLogRepository.save(log);
    }
}
