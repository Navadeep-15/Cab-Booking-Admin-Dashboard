package com.admindashboard.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public List<Report> getReportsByType(String type) {
        return reportRepository.findByType(type);
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }
}
