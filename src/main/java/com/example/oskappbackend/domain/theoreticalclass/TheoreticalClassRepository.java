package com.example.oskappbackend.domain.theoreticalclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheoreticalClassRepository extends JpaRepository<TheoreticalClass, Long> {
}
