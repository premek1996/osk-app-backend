package com.example.oskappbackend.domain.theoreticalcourseparticipation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheoreticalCourseParticipationRepository extends JpaRepository<TheoreticalCourseParticipation, Long> {
}
