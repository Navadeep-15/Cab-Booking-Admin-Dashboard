package com.admindashboard.earnings;

import com.admindashboard.driververification.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EarningRepository extends JpaRepository<Earning, Integer> {
    List<Earning> findByDriver(Driver driver);
}
