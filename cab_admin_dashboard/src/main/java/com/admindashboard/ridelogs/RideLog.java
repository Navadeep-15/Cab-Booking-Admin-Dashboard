package com.admindashboard.ridelogs;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rides")
public class RideLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long driverId;
    private String source;
    private String destination;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status; // completed, cancelled
    private String feedback;
    private String complaint;

    public RideLog() {}

    public RideLog(Long userId, Long driverId, String source, String destination,
                   LocalDateTime startTime, LocalDateTime endTime, String status,
                   String feedback, String complaint) {
        this.userId = userId;
        this.driverId = driverId;
        this.source = source;
        this.destination = destination;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.feedback = feedback;
        this.complaint = complaint;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getDriverId() { return driverId; }
    public void setDriverId(Long driverId) { this.driverId = driverId; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public String getComplaint() { return complaint; }
    public void setComplaint(String complaint) { this.complaint = complaint; }
}
