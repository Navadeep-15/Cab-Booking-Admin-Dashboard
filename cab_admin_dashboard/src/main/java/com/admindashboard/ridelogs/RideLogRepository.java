package com.admindashboard.ridelogs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RideLogRepository extends JpaRepository<RideLog, Long> {
}
