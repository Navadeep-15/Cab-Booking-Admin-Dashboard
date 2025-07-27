package com.admindashboard.earnings;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Earning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;

    private Long ride_id;
    private Long user_id;
    private Long driver_id;
    private Double amount;
    private LocalDateTime payment_time;

    // Getters and Setters

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(LocalDateTime payment_time) {
        this.payment_time = payment_time;
    }
}
