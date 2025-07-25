package com.admindashboard.earnings;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Earning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private LocalDate date;

    public Earning() {}

    public Earning(Double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
