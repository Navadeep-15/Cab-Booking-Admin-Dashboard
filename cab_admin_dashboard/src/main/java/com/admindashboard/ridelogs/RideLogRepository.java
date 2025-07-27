package com.admindashboard.ridelogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideLogRepository extends JpaRepository<RideLog, Long> {
}
