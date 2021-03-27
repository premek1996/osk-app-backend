package com.example.oskappbackend.domain.courseparticipation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseParticipationRepository extends JpaRepository<CourseParticipation, Long> {
}
