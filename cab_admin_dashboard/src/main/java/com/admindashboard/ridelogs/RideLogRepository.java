package com.admindashboard.ridelogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideLogRepository extends JpaRepository<RideLog, Long> {
    List<RideLog> findByStatus(String status);
    List<RideLog> findByComplaintIsNotNull();
}
