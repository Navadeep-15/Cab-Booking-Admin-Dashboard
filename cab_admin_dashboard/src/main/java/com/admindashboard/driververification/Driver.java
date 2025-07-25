package com.admindashboard.driververification;

import jakarta.persistence.*;

@Entity
@Table(name = "driver_details")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    private String name;
    private String licenseNumber;
    private String status; // pending, approved, rejected

    public Driver() {}

    public Driver(String name, String licenseNumber, String status) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.status = status;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
