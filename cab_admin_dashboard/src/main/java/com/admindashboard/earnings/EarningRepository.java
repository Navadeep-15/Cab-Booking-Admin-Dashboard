package com.admindashboard.earnings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EarningRepository extends JpaRepository<Earning, Long> {
    List<Earning> findByPayment_timeBetween(LocalDateTime start, LocalDateTime end);
}
