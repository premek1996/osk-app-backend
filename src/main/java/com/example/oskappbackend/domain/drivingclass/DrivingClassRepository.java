package com.example.oskappbackend.domain.drivingclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingClassRepository extends JpaRepository<DrivingClass, Long> {
}
