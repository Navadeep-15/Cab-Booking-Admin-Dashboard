package com.admindashboard.ridelogs;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rides")
public class RideLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ride_id;

    private Long user_id;
    private Long driver_id;

    private String pickup_location;
    private String drop_location;

    private LocalDateTime ride_time;
    private String status; // completed, cancelled, etc.
    private String feedback;
    private String complaint;

    // Getters and Setters
    public Long getRide_id() {
        return ride_id;
    }

    public void setRide_id(Long ride_id) {
        this.ride_id = ride_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Long driver_id) {
        this.driver_id = driver_id;
    }

    public String getPickup_location() {
        return pickup_location;
    }

    public void setPickup_location(String pickup_location) {
        this.pickup_location = pickup_location;
    }

    public String getDrop_location() {
        return drop_location;
    }

    public void setDrop_location(String drop_location) {
        this.drop_location = drop_location;
    }

    public LocalDateTime getRide_time() {
        return ride_time;
    }

    public void setRide_time(LocalDateTime ride_time) {
        this.ride_time = ride_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
