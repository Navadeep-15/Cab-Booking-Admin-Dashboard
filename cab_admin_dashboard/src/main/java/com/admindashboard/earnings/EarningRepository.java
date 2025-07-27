package com.admindashboard.earnings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarningRepository extends JpaRepository<Earning, Long> {
}
