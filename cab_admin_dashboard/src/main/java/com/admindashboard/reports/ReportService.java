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

    public Report getReportById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found with ID: " + id));
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public Report updateReport(Long id, Report updatedReport) {
        Report report = getReportById(id);
        report.setReportType(updatedReport.getReportType());
        report.setDescription(updatedReport.getDescription());
        report.setReportedAt(updatedReport.getReportedAt());
        report.setRideId(updatedReport.getRideId());
        report.setReportedByUserId(updatedReport.getReportedByUserId());
        report.setStatus(updatedReport.getStatus());
        return reportRepository.save(report);
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
