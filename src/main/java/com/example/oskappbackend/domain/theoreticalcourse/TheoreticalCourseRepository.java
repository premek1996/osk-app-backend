package com.example.oskappbackend.domain.theoreticalcourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheoreticalCourseRepository extends JpaRepository<TheoreticalCourse, Long> {
}
