package com.admindashboard.earnings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface EarningRepository extends JpaRepository<Earning, Long> {

    List<Earning> findByDateBetween(LocalDate start, LocalDate end);

    @Query("SELECT SUM(e.amount) FROM Earning e WHERE e.date BETWEEN :start AND :end")
    Double findTotalEarningsBetween(LocalDate start, LocalDate end);
}
